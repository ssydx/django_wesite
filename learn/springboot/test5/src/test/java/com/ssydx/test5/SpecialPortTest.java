package com.ssydx.test5;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.ssydx.test5.dto.AuthorDto;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class SpecialPortTest {
    // 测试RestAPI
    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    public void testIndexRest() {
        String str = restTemplate.getForObject("/rest", String.class);
        Assertions.assertEquals("欢迎访问", str);
    }
    @ParameterizedTest
    @CsvSource({"张三, 12","李四, 34"})
    public void testRestAddAuthor(String name, Byte age) {
        AuthorDto authorDto = new AuthorDto(name ,age);
        Map map = restTemplate.postForObject("/rest/addAuthor", authorDto,Map.class);
        Assertions.assertEquals(map.get("tip"), "增加成功");
    }
    @Test
    public void testRestList() {
        List ls = restTemplate.getForObject("/rest/listAuthor", List.class);
        ls.forEach(System.out::println);
    }
    @ParameterizedTest
    @ValueSource(longs = {4, 5})
    public void testRestDeleteAuthor(Long id) {
        restTemplate.delete("/rest/listAuthor/{0}", id);
    }

    // 测试控制组件
}
