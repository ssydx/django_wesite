package com.ssydx.data1.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ssydx.data1.entity.User;

@Repository
public interface UserDao2 extends PagingAndSortingRepository<User,Integer> {
    
}
