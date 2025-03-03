package com.ssydx.test5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssydx.test5.entity.ArticleEntity;
import com.ssydx.test5.repository.ArticleRepository;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    public List<ArticleEntity> getAllArticle() {
        return articleRepository.findAll();
    }
    public Long addArticle(ArticleEntity articleEntity) {
        articleRepository.save(articleEntity);
        return articleEntity.getId();
    }
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }
    public ArticleEntity getArticle(Long id) {
        return articleRepository.findById(id).get();
    }

}
