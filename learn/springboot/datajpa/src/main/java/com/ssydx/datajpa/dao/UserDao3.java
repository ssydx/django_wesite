package com.ssydx.datajpa.dao;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.ssydx.datajpa.domain.User;

@Repository
public interface UserDao3 extends ListCrudRepository<User,Integer> {
    
}
