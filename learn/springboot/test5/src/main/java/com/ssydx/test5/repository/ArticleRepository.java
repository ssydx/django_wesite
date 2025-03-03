package com.ssydx.test5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssydx.test5.entity.ArticleEntity;

public interface ArticleRepository extends JpaRepository<ArticleEntity,Long> {
    
}
