package com.ssydx.website.app;

import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.ssydx.website.app.domain.User;
import com.ssydx.website.app.redis.UserRedis;
import com.ssydx.website.app.dao.RedisDao;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class TestRedis {
    @Autowired
    private RedisDao redisDao;

    @Test
    public void testSave() {
        // String key = UUID.randomUUID().toString();
        User user = new User(1L,"zhangsan","zhangsan",new Date(),new Date(),1,null);
        redisDao.set(UserRedis.prefix, user.getUserName(), user, UserRedis.expiredSeconds);
        System.out.println(redisDao.get(UserRedis.prefix, user.getUserName(), User.class));
    }
}
