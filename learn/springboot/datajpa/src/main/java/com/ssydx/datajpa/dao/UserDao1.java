package com.ssydx.datajpa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ssydx.datajpa.domain.User;

@Repository
public interface UserDao1 extends CrudRepository<User,Integer> {
    
}
