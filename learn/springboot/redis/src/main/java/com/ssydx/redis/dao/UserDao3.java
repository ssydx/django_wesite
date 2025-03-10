package com.ssydx.redis.dao;

import java.util.List;
import java.util.Map;

import com.ssydx.redis.domain.User;

public interface UserDao3 {
    void hmset(String key, Map<String,String> hash);
    List<User> customQuery(int age);
}
