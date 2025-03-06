package com.ssydx.test5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ActiveProfiles;

import com.ssydx.test5.dto.AuthorDto;
import com.ssydx.test5.entity.AuthorEntity;
import com.ssydx.test5.repository.AuthorDao;
import com.ssydx.test5.service.AuthorService;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class NoneTest {
    @Autowired
    private AuthorService authorService;
    @Test
    public void testgetAllbooks() {
        authorService.getAllAuthor().forEach(System.out::println);
    }
    @ParameterizedTest
    @CsvSource({"张三, 12","李四, 34"})
    public void testAddAuthor(String name,Byte age) {
        var author = new AuthorDto(name,age);
        Long res = authorService.addAuthor(author);
        Assertions.assertNotEquals(res, 0);
    }
    @Test
    public void test() {
        Page<AuthorEntity> res = authorService.getAllAuthorPage(2, 5);
        res.forEach(System.out::println);
        System.out.println(res.getTotalElements());
        System.out.println(res.getTotalPages());
    }
}
