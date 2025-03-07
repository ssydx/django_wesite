package com.ssydx.mybatis.dao;

import java.util.List;

import com.ssydx.mybatis.domain.User;

public interface UserDao2 {
    List<User> select();
    int insert(User user);
    int update(User user);
    int delete(Long id);
}
