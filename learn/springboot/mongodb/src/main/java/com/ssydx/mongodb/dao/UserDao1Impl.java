package com.ssydx.mongodb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.ssydx.mongodb.domain.User;

@Repository
public class UserDao1Impl implements UserDao1 {
    @Autowired
    MongoTemplate template;
    public List<User> get() {
        return template.findAll(User.class);
    }
}
