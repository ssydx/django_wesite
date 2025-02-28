package com.springboot.myblog;



import static org.mockito.Mockito.when;

import java.util.Arrays;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import com.springboot.myblog.entity.Article;
import com.springboot.myblog.entity.User;
import com.springboot.myblog.repository.ArticleRepository;
import com.springboot.myblog.repository.UserRepository;

@WebMvcTest
public class HttpControllersTests {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private ArticleRepository articleRepository;

    @Test
    void listArticle() throws Exception {
        User meimeihan = new User().setLogin("meimeihan").setFirstName("meimei").setLastName("han");
        Article article1 = new Article().setTitle("the title1").setHeadline("headline1").setContent("content1").setAuthor(meimeihan).setSlug("1");
        Article article2 = new Article().setTitle("the title2").setHeadline("headline2").setContent("content2").setAuthor(meimeihan).setSlug("3");
        when(articleRepository.findAllByOrderByAddedAtDesc()).thenReturn(Arrays.asList(article1,article2));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/article/")
            .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].author.login").value(meimeihan.getLogin()))
                .andExpect(jsonPath("$[0].slug").value(article1.getSlug()))
                .andExpect(jsonPath("$[1].author.login").value(meimeihan.getLogin()))
                .andExpect(jsonPath("$[1].slug").value(article2.getSlug()));
    }
}
