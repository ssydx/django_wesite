package com.ssydx.jdbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.ssydx.jdbc.dao.UserDao;
import com.ssydx.jdbc.domain.User;

@Service
public class UserService implements CommandLineRunner {
    @Autowired
    UserDao userDao;
    public void run(String... args) {
        userDao.insert(new User().setName("张三").setAge(30));
        userDao.insert(new User().setName("李四").setAge(22));
        userDao.insert(new User().setName("王五").setAge(18));
        userDao.select().forEach(System.out::println);
        userDao.update(new User(1L, "张总", 45));
        userDao.select().forEach(System.out::println);
        userDao.delete(2L);
        userDao.select().forEach(System.out::println);
    }
}
