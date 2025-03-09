package com.ssydx.redis.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import com.ssydx.redis.domain.User1;

@Repository
public interface UserDao1 extends CrudRepository<User1, Integer>, QueryByExampleExecutor<User1> {

}
