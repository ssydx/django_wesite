package com.ssydx.elasticsearch.dao;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssydx.elasticsearch.domain.User;

public interface UserDao extends CrudRepository<User,Integer>,UserCustomDao {
    List<User> findByName(String name);
    List<User> findByIdIn(List<Integer> list);
    List<User> findByScoreBetween(double start, double end);
    List<User> findByDescMatches(String descPattern);
    @Query("{ \"match\": { \"?0\": \"?1\" } }")
    List<User> findByQuery1(String field, String term);
}
