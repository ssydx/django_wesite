package com.ssydx.website.app.dao;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import com.ssydx.website.app.domain.UserHash;

public interface UserDao extends ListCrudRepository<UserHash,Long> {
    Optional<UserHash> findByName(String name);
}
