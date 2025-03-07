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
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ssydx.datajpa.dao.UserDao1;
import com.ssydx.datajpa.dao.UserDao2;
import com.ssydx.datajpa.dao.UserDao3;
import com.ssydx.datajpa.dao.UserDao4;
import com.ssydx.datajpa.dao.UserDao5;
import com.ssydx.datajpa.dao.UserDao6;
import com.ssydx.datajpa.dao.UserDao8;
import com.ssydx.datajpa.domain.User;

import jakarta.persistence.criteria.Predicate;
import jakarta.transaction.Transactional;

// @Service
public class UserService5 implements CommandLineRunner {
    @Autowired
    private UserDao6 userDao6;
    @Autowired
    private UserDao8 userDao8;
    @Override
    public void run(String... args) {
        userDao6.save(new User().setName("zhangsan").setGender('m').setAge(30));
        userDao6.save(new User().setName("zhangsan").setGender('m').setAge(37));
        userDao6.save(new User().setName("zhangsan").setGender('f').setAge(32));
        userDao6.save(new User().setName("lisi").setGender('f').setAge(25));
        userDao6.save(new User().setName("wangwu").setGender('m').setAge(35));
        userDao8.findAll((Specification<User>) (root,query,cb) -> {
            return cb.equal(root.get("gender"), "m");
        }).forEach(System.out::println);

        User u = new User().setName("zhangsan").setGender('m');
        userDao8.findAll((root,query,cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (u != null) {
                // 不为null且不为空字符串
                if (StringUtils.hasText(u.getName())) {
                    predicates.add(cb.like(root.get("name"),"%" + u.getName() + "%"));
                }
                if (u.getGender() != '\0') {
                    predicates.add(cb.equal(root.get("gender"),u.getGender()));
                }
                if (u.getAge() != 0) {
                    predicates.add(cb.greaterThanOrEqualTo(root.get("age"), u.getAge()));
                }
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        }).forEach(System.out::println);
    }
}
