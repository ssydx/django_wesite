package com.ssydx.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.ssydx.redis.dao.UserDao2;
import com.ssydx.redis.domain.User2;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class UserDaoTest2 {
    @Autowired
    private UserDao2 userDao1;

    @Test
    public void testSaveWithId() {
        var user = new User2().setId(1).setName("张三").setDescription("张三是个傻逼").setAge(25).setTimeout(1L);
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
        userDao1.deleteAll();
    }

}
