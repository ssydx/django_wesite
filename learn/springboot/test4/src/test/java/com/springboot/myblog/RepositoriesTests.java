package com.springboot.myblog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.springboot.myblog.entity.Article;
import com.springboot.myblog.entity.User;
import com.springboot.myblog.repository.ArticleRepository;
import com.springboot.myblog.repository.UserRepository;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class RepositoriesTests {
    @Autowired
    TestEntityManager entityManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ArticleRepository articleRepository;

    @Test
    void whenFindByIdOrNull_thenReturnArticle() {
        User leili = new User().setLogin("leili").setFirstName("lei").setLastName("li");
        entityManager.persist(leili);
        Article article = new Article().setTitle("Spring Boot 5.0 goes GA").setHeadline("Dear Spring community ...").setContent("Lorem ipsum").setAuthor(leili);
        entityManager.persist(article);
        entityManager.flush();
        Article found = articleRepository.findById(article.getId()).orElse(null);
        assertThat(article).isEqualTo(found);
    }

    @Test
    void whenFindByLogin_thenReturnUser() {
        User leili = new User().setLogin("leili").setFirstName("lei").setLastName("li");
        entityManager.persist(leili);
        entityManager.flush();
        User user = userRepository.findByLogin(leili.getLogin());
        assertThat(user).isEqualTo(leili);
    }
}
