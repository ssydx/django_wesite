package com.ssydx.data.springDataJpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface UserDao4 extends JpaRepository<UserDomain4,Integer>,JpaSpecificationExecutor<UserDomain4>, UserCustomDao4 {
    List<UserDomain4> namedQuery1(Integer id);
    @Query(value = "select * from user_info where id = ?",nativeQuery = true)
    List<UserDomain4> query1(Integer id);
}
