package com.ssydx.datajpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.ssydx.datajpa.dao.UserDao6;
import com.ssydx.datajpa.domain.User;

@Service
public class UserService3 implements CommandLineRunner {
    @Autowired
    private UserDao6 userDao6;
    @Override
    public void run(String... args) {
        userDao6.save(new User().setName("zhangsan").setGender('m').setAge(30));
        userDao6.save(new User().setName("zhangsan").setGender('m').setAge(30));
        userDao6.save(new User().setName("zhangsan").setGender('f').setAge(32));
        userDao6.save(new User().setName("lisi").setGender('f').setAge(25));
        userDao6.save(new User().setName("wangwu").setGender('m').setAge(35));
        userDao6.customSQL("zhangsan").forEach(System.out::println);
        userDao6.customJPQL("zhangsan").forEach(System.out::println);
    }
}
