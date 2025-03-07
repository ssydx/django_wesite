package com.ssydx.datajpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ssydx.datajpa.dao.UserDao1;
import com.ssydx.datajpa.dao.UserDao2;
import com.ssydx.datajpa.dao.UserDao3;
import com.ssydx.datajpa.dao.UserDao4;
import com.ssydx.datajpa.dao.UserDao5;
import com.ssydx.datajpa.dao.UserDao6;
import com.ssydx.datajpa.domain.User;

import jakarta.transaction.Transactional;

// @Service
public class UserService4 implements CommandLineRunner {
    @Autowired
    private UserDao6 userDao6;
    @Autowired
    private UserDao6 userDao7;
    @Override
    public void run(String... args) {
        userDao6.save(new User().setName("zhangsan").setGender('m').setAge(30));
        userDao6.save(new User().setName("zhangsan").setGender('m').setAge(30));
        userDao6.save(new User().setName("zhangsan").setGender('f').setAge(32));
        userDao6.save(new User().setName("lisi").setGender('f').setAge(25));
        userDao6.save(new User().setName("wangwu").setGender('m').setAge(35));
        // 对于没设置的属性，按默认值算，如果该默认值为null，则不参与比较。即基本类型永远参与匹配，引用类型如果没初始化则不参与
        // 此处由于主键是Long引用类型，未赋值所以不参与匹配
        System.out.println(userDao7.count(Example.of(new User().setName("zhangsan").setGender('m').setAge(30))));
        System.out.println(userDao7.count(Example.of(new User().setName("Zh").setGender('m').setAge(30), ExampleMatcher.matchingAll().withIgnoreCase().withIgnorePaths("age","gender").withMatcher("name", ExampleMatcher.GenericPropertyMatcher.of(ExampleMatcher.StringMatcher.STARTING)))));
        System.out.println(userDao7.count(Example.of(new User().setName("Zh").setGender('m').setAge(30), ExampleMatcher.matchingAll().withIgnorePaths("age","gender").withMatcher("name", e -> e.contains().ignoreCase()))));
    }
}
