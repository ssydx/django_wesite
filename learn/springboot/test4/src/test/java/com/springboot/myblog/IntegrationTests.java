package com.springboot.myblog;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.springboot.myblog.domain.SubmitArticleQuery;
import com.springboot.myblog.util.CommonUtil;

import static org.assertj.core.api.Assertions.assertThat;

// 测试的类为MyblogApplication，测试的环境为特定端口
@SpringBootTest(classes = {MyblogApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class IntegrationTests {
    @Autowired
    TestRestTemplate restTemplate;

    @BeforeAll
    void setup() {
        System.out.println(">> start");
    }

    // 测试内容和状态码
    @Test
    void assertBlogPageTitle_Content_And_StatusCode() {
        ResponseEntity<String> entity = restTemplate.getForEntity("/", String.class);
        // 测试状态码
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        // 测试内容
        assertThat(entity.getBody()).contains("<title>Blog</title>");
    }
    @Test
    void assertArticlePageTitle_Content_And_StatusCode() {
        String title = "1";
        ResponseEntity<String> entity = restTemplate.getForEntity(String.format("/article/%s", CommonUtil.toSlug(title)), String.class);
        System.out.println(String.format("/article/%s", CommonUtil.toSlug(title)));
        System.out.println(entity);
        // 测试状态码
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        // 测试内容
        assertThat(entity.getBody()).contains(title, "headline1");
    }

    @AfterAll
    void teardown() {
        System.out.println(">> teardown");
    }

    @Test
    void submitArticle() {
        System.out.println(">> 提交文章");
        SubmitArticleQuery query = new SubmitArticleQuery()
            .setAuthor("anomyous")
            .setTitle("title")
            .setHeadline("headline")
            .setContent("content");
        ResponseEntity<String> entity = restTemplate.postForEntity("/article", query, String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        SubmitArticleQuery query2 = new SubmitArticleQuery()
            .setAuthor("meimeihan")
            .setTitle("title2")
            .setHeadline("headline2")
            .setContent("content2");
        ResponseEntity<String> entity2 = restTemplate.postForEntity("/article", query2, String.class);
        assertThat(entity2.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity2.getBody()).contains("success");
    }
}
