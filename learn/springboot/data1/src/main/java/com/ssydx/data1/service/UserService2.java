package com.ssydx.data1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ssydx.data1.dao.UserDao1;
import com.ssydx.data1.dao.UserDao2;
import com.ssydx.data1.dao.UserDao3;
import com.ssydx.data1.dao.UserDao4;
import com.ssydx.data1.dao.UserDao5;
import com.ssydx.data1.entity.User;

@Service
public class UserService2 implements CommandLineRunner {
    @Autowired
    private UserDao5 userDao5;
    @Override
    public void run(String... args) {
        userDao5.save(new User().setName("zhangsan").setGender('m').setAge(30));
        userDao5.save(new User().setName("zhangsan").setGender('m').setAge(30));
        userDao5.save(new User().setName("zhangsan").setGender('f').setAge(32));
        userDao5.save(new User().setName("lisi").setGender('f').setAge(25));
        userDao5.save(new User().setName("wangwu").setGender('m').setAge(35));
        System.out.println("打印所有");
        userDao5.findAll().forEach(System.out::println);
        System.out.println("byname");
        userDao5.findByName("zhangsan").forEach(System.out::println);
        System.out.println("byage");
        userDao5.findByAge(25).ifPresent(System.out::println);
        System.out.println("by name or age");
        userDao5.findByNameOrAge("zhangsan", 35).forEach(System.out::println);
        System.out.println("count");
        System.out.println(userDao5.countByName("zhangsan"));
        System.out.println("by name and age");
        System.out.println(userDao5.findBynameAndAge("zhangsan", 32));
        System.out.println("not name");
        userDao5.findByNameNot("zhangsan").forEach(System.out::println);
        System.out.println("lessthan");
        userDao5.findByAgeLessThan(30).forEach(System.out::println);
        System.out.println("greaterthanequal");
        userDao5.findByAgeGreaterThanEqual(30).forEach(System.out::println);
        System.out.println("between");
        userDao5.findByAgeBetween(30,35).forEach(System.out::println);
        
    }
}
