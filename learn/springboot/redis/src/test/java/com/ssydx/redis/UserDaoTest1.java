package com.ssydx.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.ssydx.redis.dao.UserDao1;
import com.ssydx.redis.domain.User1;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class UserDaoTest1 {
    @Autowired
    private UserDao1 userDao1;

    @Test
    public void testSaveWithId() {
        var user = new User1().setId(1).setName("李四").setDescription("李四不是").setAge(25).setTimeout(1L);
        userDao1.save(user);
    }
    @Test
    public void testUpdateWithId() {
        userDao1.findById(2).ifPresent(u -> {
            u.setName("李四");
            u.setDescription("李四也是个傻逼");
        });
    }
    @Test
    public void testDelete() {
        userDao1.deleteById(1);
    }

}
