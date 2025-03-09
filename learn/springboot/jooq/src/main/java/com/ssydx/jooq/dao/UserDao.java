package com.ssydx.jooq.dao;

import java.util.List;

import com.ssydx.jooq.domain.tables.records.UserInfoRecord;

public interface UserDao {
    int insert(UserInfoRecord userInfoRecord);
    List<UserInfoRecord> select();
}
