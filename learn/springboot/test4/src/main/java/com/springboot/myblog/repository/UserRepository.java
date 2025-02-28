package com.springboot.myblog.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.myblog.entity.User;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByLogin(String login);
    Iterable<User> findAll();
}
