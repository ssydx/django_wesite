package com.ssydx.data1.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ssydx.data1.entity.User;

@Repository
public interface UserDao1 extends CrudRepository<User,Integer> {
    
}
