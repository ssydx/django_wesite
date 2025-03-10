package com.ssydx.elasticsearch.dao;

import java.util.List;

import com.ssydx.elasticsearch.domain.User;

public interface UserCustomDao {
    List<User> customQuery(String name,String desc);
}
