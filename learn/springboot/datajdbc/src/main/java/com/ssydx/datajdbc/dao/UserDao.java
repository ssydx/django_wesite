package com.ssydx.datajdbc.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ssydx.datajdbc.domain.User;

@Repository
public interface UserDao extends CrudRepository<User,Long> {
    
}
