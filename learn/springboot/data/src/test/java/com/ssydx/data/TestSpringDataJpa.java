package com.ssydx.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.ssydx.data.springDataJpa.UserDao4;
import com.ssydx.data.springDataJpa.UserDomain4;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class TestSpringDataJpa {
    @Autowired
    private UserDao4 userDao4;

    @Test
    public void test1() {
        userDao4.save(new UserDomain4("杨七","杨七是暂无工作的无业游民",0.0));
        userDao4.findAll().forEach(System.out::println);
    }
    @Test
    public void test2() {
        userDao4.myfindAll().forEach(System.out::println);
    }
    @Test
    public void test3() {
        userDao4.namedQuery1(3).forEach(System.out::println);
    }
    @Test
    public void test4() {
        userDao4.query1(3).forEach(System.out::println);
    }
}
