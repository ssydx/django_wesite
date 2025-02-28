package com.springboot.myblog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.springboot.myblog.entity.Article;
import com.springboot.myblog.repository.ArticleRepository;
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/article")
public class ArticleController {
    private final ArticleRepository articleRepository;
    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }
    @GetMapping("/")
    public Iterable<Article> findAll() {
        return articleRepository.findAllByOrderByAddedAtDesc();
    }
    @GetMapping("/{slug}")
    public Article finOne(@PathVariable String slug) {
        Article res = articleRepository.findBySlug(slug);
        if (res == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "this article does not exist");
        }
        return res;
    }
}
