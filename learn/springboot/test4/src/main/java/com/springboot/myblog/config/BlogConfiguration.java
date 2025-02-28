package com.springboot.myblog.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import com.springboot.myblog.entity.Article;
import com.springboot.myblog.entity.User;
import com.springboot.myblog.repository.ArticleRepository;
import com.springboot.myblog.repository.UserRepository;

@Configuration
public class BlogConfiguration implements ApplicationRunner {
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;
    public BlogConfiguration(UserRepository userRepository,ArticleRepository articleRepository) {
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        User meimeihan = userRepository.save(new User().setLogin("meimeihan").setFirstName("meimei").setLastName("han"));
        articleRepository.save(new Article().setTitle("the title1").setHeadline("headline1").setContent("content1").setAuthor(meimeihan).setSlug("1"));
        articleRepository.save(new Article().setTitle("the title2").setHeadline("headline2").setContent("content2").setAuthor(meimeihan).setSlug("2"));
    }
}
