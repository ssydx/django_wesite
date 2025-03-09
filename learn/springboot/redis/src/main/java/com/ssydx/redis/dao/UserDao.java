package com.ssydx.redis.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import com.ssydx.redis.domain.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer>, QueryByExampleExecutor<User> {
    List<User> findByName(String name);
    List<User> findByDescription(String subDesc);
}
