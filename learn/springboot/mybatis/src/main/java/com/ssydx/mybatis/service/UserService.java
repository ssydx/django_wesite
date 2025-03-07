package com.ssydx.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.ssydx.mybatis.dao.UserDao1;
import com.ssydx.mybatis.dao.UserDao2;
import com.ssydx.mybatis.domain.User;

@Service
public class UserService implements CommandLineRunner {
    @Autowired
    private UserDao1 userDao1;
    @Autowired
    private UserDao2 userDao2;
    public void run(String... args) {
        // userDao1.insert(new User().setName("张三").setAge(30));
        // userDao1.insert(new User().setName("李四").setAge(20));
        // userDao1.insert(new User().setName("王五").setAge(40));
        // userDao1.select().forEach(System.out::println);
        // userDao1.update(new User(1L, "张总", 45));
        // userDao1.select().forEach(System.out::println);
        // userDao1.delete(2L);
        // userDao1.select().forEach(System.out::println);
        userDao2.insert(new User().setName("张三").setAge(30));
        userDao2.insert(new User().setName("李四").setAge(20));
        userDao2.insert(new User().setName("王五").setAge(40));
        userDao2.select().forEach(System.out::println);
        userDao2.update(new User(1L, "张总", 45));
        userDao2.select().forEach(System.out::println);
        userDao2.delete(2L);
        userDao2.select().forEach(System.out::println);
    }
}
