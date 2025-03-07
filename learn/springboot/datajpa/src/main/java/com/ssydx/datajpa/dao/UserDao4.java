package com.ssydx.datajpa.dao;

import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ssydx.datajpa.domain.User;

@Repository
public interface UserDao4 extends ListPagingAndSortingRepository<User,Integer> {
    
}
