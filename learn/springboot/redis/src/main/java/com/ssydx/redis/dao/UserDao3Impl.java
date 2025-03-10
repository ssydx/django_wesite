package com.ssydx.redis.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import com.ssydx.redis.domain.User;

@Repository
public class UserDao3Impl implements UserDao3 {
    @Autowired
    private StringRedisTemplate template;

    @Override
    public void hmset(String key, Map<String,String> hash) {
        template.opsForHash().putAll(key, hash);
    }
    @Override
    public List<User> customQuery(int age) {
        return template.execute(
            (RedisCallback<List<User>>) connection -> {
                List<User> res = new ArrayList<>();
                StringRedisConnection conn = (StringRedisConnection) connection;
                // 获取user的id集合
                Set<String> ids = conn.sMembers("user");
                // 遍历该id集合
                for (String idStr : ids) {
                    String objKey = "user:" + idStr;
                    // 获取每个user的字典
                    Map<String,String> data = conn.hGetAll(objKey);
                    // 取出age字段的值
                    String curAgeStr = data.get("age");
                    // 业务逻辑，取出年龄大于给定值的用户集
                    if (curAgeStr != null) {
                        int curAge = Integer.parseInt(curAgeStr);
                        if (curAge > age) {
                            Integer id = Integer.parseInt(idStr);
                            String name = data.get("name");
                            String description = data.get("description");
                            var user = new User(id, name, description, curAge, null);
                            res.add(user);
                        }
                    }
                }
                return res;
            }
        );
    }
}
