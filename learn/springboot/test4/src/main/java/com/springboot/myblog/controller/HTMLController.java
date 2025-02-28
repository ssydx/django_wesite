package com.springboot.myblog.controller;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import com.springboot.myblog.domain.RenderedArticle;
import com.springboot.myblog.domain.SubmitArticleQuery;
import com.springboot.myblog.entity.Article;
import com.springboot.myblog.entity.People;
import com.springboot.myblog.entity.User;
import com.springboot.myblog.repository.ArticleRepository;
import com.springboot.myblog.repository.UserRepository;
import com.springboot.myblog.util.CommonUtil;

import com.springboot.myblog.config.BlogProperties;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class HTMLController {
    private final ArticleRepository repository;
    private final UserRepository userRepository;
    private final BlogProperties BlogProperties;
    private RenderedArticle render(Article article) {
        return new RenderedArticle()
            .setTitle(article.getTitle())
            .setHeadline(article.getHeadline())
            .setSlug(article.getSlug())
            .setContent(article.getContent())
            .setAuthor(article.getAuthor())
            .setAddedAt(CommonUtil.format(article.getAddedAt()));
    }
    @GetMapping("/")
    public String blog(Model m) {
        m.addAttribute("title", BlogProperties.getTitle());
        m.addAttribute("banner", BlogProperties.getBanner());
        m.addAttribute(
            "articles", 
            StreamSupport.stream(
                repository
                    .findAllByOrderByAddedAtDesc()
                    .spliterator(),
                true
            ).map(this::render).collect(Collectors.toList())
        );
        return "blog";
    }
    @GetMapping("/article/{slug}")
    public String article(@PathVariable String slug, Model m) {
        Article article = repository.findBySlug(slug);
        if (article == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"this article does not exist");
        }
        RenderedArticle renderedArticle = render(article);
        m.addAttribute("title", renderedArticle.getTitle());
        m.addAttribute("article", renderedArticle);
        return "article";
    }
    @GetMapping("/index")
    public String index(Model m) {
        m.addAttribute("title", "测试网页");
        People p = new People().setId(1l).setName("a").setAge(30);
        m.addAttribute("people", p);
        m.addAttribute("show", true);
        m.addAttribute("hide", false);
        Integer[] arr = {1,2,3,4,5};
        m.addAttribute("arr", arr);
        People[] ps = {p,p,p};
        m.addAttribute("peoples", ps);
        m.addAttribute("var", "变量");
        return "index";
    }
    @GetMapping("/writing")
    public String article(Model m) {
        Iterable<User> useList = userRepository.findAll();
        m.addAttribute("users", useList);
        m.addAttribute("title", "writing");
        return "writing";
    }
    @PostMapping("/article")
    @ResponseBody
    public String submitArticle(@RequestBody SubmitArticleQuery query) {
        User author = userRepository.findByLogin(query.getAuthor());
        if (author == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"这个作者不存在");
        }
        Article article = new Article().setAuthor(author)
            .setTitle(query.getTitle())
            .setHeadline(query.getHeadline())
            .setContent(query.getContent())
            .setSlug(CommonUtil.toSlug(query.getTitle()));
        repository.save(article);
        return "success";
    }
}
