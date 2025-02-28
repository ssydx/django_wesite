package com.springboot.myblog.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.myblog.entity.Article;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    Article findBySlug(String slug);
    Iterable<Article> findAllByOrderByAddedAtDesc();
    
}
