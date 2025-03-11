package com.ssydx.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.ssydx.data.jdbc.UserDao1;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class TestJdbc {
    @Autowired
    private UserDao1 userDao;

    @Test
    public void testQuery1() {
        userDao.query1().forEach(System.out::println);
    }
}
