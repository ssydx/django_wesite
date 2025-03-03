package com.ssydx.test5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssydx.test5.entity.AuthorEntity;

public interface AuthorRepository extends JpaRepository<AuthorEntity,Long>{
    
}
