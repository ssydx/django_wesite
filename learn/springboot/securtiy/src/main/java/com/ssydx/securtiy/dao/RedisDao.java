package com.ssydx.securtiy.dao;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;


@Repository
public class RedisDao {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    public <T> boolean set(String prefix, String key, T value, int expiredSeconds) {
        try {
            String realValue = objectMapper.writeValueAsString(value);
            String realKey = "";
            if (key != null && key.length() != 0) {
                realKey = prefix + ":" + key;
            } else {
                realKey = prefix;
            }
            if (expiredSeconds <= 0) {
                redisTemplate.opsForValue().set(realKey, realValue);
            } else {
                Duration realExpiredSeconds = Duration.ofSeconds(expiredSeconds);
                redisTemplate.opsForValue().set(realKey, realValue, realExpiredSeconds);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public <T> T get(String prefix, String key, Class<T> clazz) {
        try {
            String realKey = "";
            if (key != null && key.length() != 0) {
                realKey = prefix + ":" + key;
            } else {
                realKey = prefix;
            }
            String value = redisTemplate.opsForValue().get(realKey);
            T realValue = objectMapper.readValue(value, clazz);
            return realValue;
        } catch (Exception e) {
            return null;
        }
    }
    public boolean reset(String prefix, String key, int expiredSeconds) {
        String realKey = prefix + ":" + key;
        Duration realExpiredSeconds = Duration.ofSeconds(expiredSeconds);
        return redisTemplate.expire(realKey, realExpiredSeconds);
    }
    public boolean isExist(String prefix, String key) {
        String realKey = prefix + ":" + key;
        return redisTemplate.hasKey(realKey);
    }
    public boolean delete(String prefix, String key) {
        String realKey = prefix + ":" + key;
        return redisTemplate.delete(realKey);
    }
    public Long decr(String prefix, String key) {
        String realKey = prefix + ":" + key;
        return redisTemplate.opsForValue().decrement(realKey);
    }
}
