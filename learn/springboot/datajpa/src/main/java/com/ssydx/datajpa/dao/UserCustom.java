package com.ssydx.datajpa.dao;

import java.util.List;

import com.ssydx.datajpa.domain.User;

public interface UserCustom {
    List<User> customJPQL(String name);
    List<User> customSQL(String name);
}
