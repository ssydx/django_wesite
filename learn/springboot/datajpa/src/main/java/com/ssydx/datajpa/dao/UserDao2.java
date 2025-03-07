package com.ssydx.datajpa.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ssydx.datajpa.domain.User;

@Repository
public interface UserDao2 extends PagingAndSortingRepository<User,Integer> {
    
}
