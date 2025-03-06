package com.ssydx.data1.dao;

import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ssydx.data1.entity.User;

@Repository
public interface UserDao4 extends ListPagingAndSortingRepository<User,Integer> {
    
}
