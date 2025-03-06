package com.ssydx.data1.dao;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.ssydx.data1.entity.User;

@Repository
public interface UserDao3 extends ListCrudRepository<User,Integer> {
    
}
