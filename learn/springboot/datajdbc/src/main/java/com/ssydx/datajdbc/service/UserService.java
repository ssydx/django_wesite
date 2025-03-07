package com.ssydx.datajdbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.ssydx.datajdbc.dao.UserDao;
import com.ssydx.datajdbc.domain.User;

@Service
public class UserService implements CommandLineRunner {
    @Autowired
    private UserDao userDao;
    public void run(String... args) {
        userDao.save(new User().setName("张三").setAge(30));
        userDao.save(new User().setName("李四").setAge(20));
        userDao.save(new User().setName("王五").setAge(50));
        userDao.findAll().forEach(System.out::println);
    }
}
