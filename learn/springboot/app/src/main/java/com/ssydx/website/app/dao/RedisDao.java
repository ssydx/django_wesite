package com.ssydx.website.app.dao;

public interface RedisDao {
    <T> boolean set(String prefix, String key, T value, int expiredSeconds);
    <T> T get(String prefix, String key, Class<T> clazz);
    boolean reset(String prefix, String key, int expiredSeconds);
    boolean isExist(String prefix, String key);
    boolean delete(String prefix, String key);
}
