package com.ssydx.datajpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssydx.datajpa.domain.User;

@Repository
public interface UserDao6 extends JpaRepository<User,Integer>,UserCustom  {

}
