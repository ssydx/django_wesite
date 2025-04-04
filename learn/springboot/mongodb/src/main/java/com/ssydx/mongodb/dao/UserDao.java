package com.ssydx.mongodb.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ssydx.mongodb.domain.User;

@Repository
public interface UserDao extends CrudRepository<User,String> {
    
}
