package com.ssydx.shizhan.redis;

import java.time.Duration;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RedisUtil {
    private final RedisTemplate<String,String> redisTemplate;
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public RedisUtil(RedisTemplate<String,String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    public <T> T get(KeyPrefix prefix, String key,Class<T> clazz) {
        String realKey = prefix.getPrefix() + key;
        String str = redisTemplate.opsForValue().get(realKey);
        try {
            return stringToBean(str,clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public <T> Boolean set(KeyPrefix prefix, String key,T value) {
        String str = null;
        try {
            str = beanToString(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (str == null || str.length() <= 0) {
            return false;
        }
        String realKey = prefix.getPrefix() + key;
        int seconds = prefix.expireSeconds();
        if (seconds <= 0) {
            redisTemplate.opsForValue().set(realKey, str);
        } else {
            redisTemplate.opsForValue().set(realKey, str,Duration.ofSeconds(seconds));
        }
        return true;
    }
    public Boolean exists(KeyPrefix prefix,String key) {
        String realPrefix = prefix.getPrefix() + key;
        return redisTemplate.hasKey(realPrefix);
    }
    public Boolean delete(KeyPrefix prefix, String key) {
        String realPrefix = prefix.getPrefix() + key;
        return redisTemplate.delete(realPrefix);
    }
    public Long incr(KeyPrefix prefix, String key) {
        String realPrefix = prefix.getPrefix() + key;
        return redisTemplate.opsForValue().increment(realPrefix);
    }
    public Long decr(KeyPrefix prefix, String key) {
        String realPrefix = prefix.getPrefix() + key;
        return redisTemplate.opsForValue().decrement(realPrefix);
    }
    // 对象转字符串
    public static <T> String beanToString(T value) throws JsonProcessingException {
        if (value == null) {
            return null;
        }
        Class<?> clazz = value.getClass();
        if (clazz == Integer.class || clazz == int.class || clazz == Long.class || clazz == long.class || clazz == String.class) {
            return value.toString();
        } else {
            return objectMapper.writeValueAsString(value);
        }
    }
    // 字符串转对象
    public static <T> T stringToBean(String str,Class<T> clazz) throws JsonProcessingException {
        if (str == null || str.length() <= 0 || clazz == null) {
            return null;
        }
        if (clazz == int.class || clazz == Integer.class) {
            return (T)Integer.valueOf(str);
        } else if (clazz == long.class || clazz == Long.class) {
            return (T)Long.valueOf(str);
        } else if (clazz == String.class) {
            return (T) str;
        } else {
            return objectMapper.readValue(str, clazz);
        }
    }
}
