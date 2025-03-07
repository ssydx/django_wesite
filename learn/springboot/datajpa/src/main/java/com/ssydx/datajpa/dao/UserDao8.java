package com.ssydx.datajpa.dao;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ssydx.datajpa.domain.User;

import jakarta.transaction.Transactional;

@Repository
public interface UserDao8 extends JpaRepository<User,Integer>,JpaSpecificationExecutor<User> {

}
