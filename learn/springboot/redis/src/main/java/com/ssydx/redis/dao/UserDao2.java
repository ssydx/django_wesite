package com.ssydx.redis.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import com.ssydx.redis.domain.User2;

@Repository
public interface UserDao2 extends CrudRepository<User2, Integer>, QueryByExampleExecutor<User2> {

}
