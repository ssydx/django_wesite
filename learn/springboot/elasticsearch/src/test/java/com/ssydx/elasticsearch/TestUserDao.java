package com.ssydx.elasticsearch;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.transaction.annotation.Transactional;

import com.ssydx.elasticsearch.dao.UserDao;
import com.ssydx.elasticsearch.domain.User;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class TestUserDao {
    @Autowired
    private UserDao userDao;

    @ParameterizedTest
    @CsvSource({"1,张三,一个傻逼,339.0","2,ls,另一个傻逼,455.0","3,ww,检查 Spring Data Elasticsearch 和 Elasticsearch 版本之间的兼容性。,568.0"})
    public void test1(Integer id, String name,String desc,Double score) {
        userDao.save(new User(id,name,desc,score));
    }
    @Test
    public void test2() {
        userDao.findByIdIn(List.of(1,2)).forEach(System.out::println);
    }
    @Test
    public void test3() {
        userDao.findByDescMatches("傻.+").forEach(System.out::println);
    }
    @Test
    public void test4() {
        userDao.findByQuery1("desc", "一个").forEach(System.out::println);
    }
    @Test
    public void test5() {
        userDao.customQuery("张", "傻").forEach(System.out::println);
    }
}
