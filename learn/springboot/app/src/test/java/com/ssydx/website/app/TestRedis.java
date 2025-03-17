package com.ssydx.website.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.ssydx.website.app.dao.UserDao;
import com.ssydx.website.app.domain.UserHash;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class TestRedis {
    @Autowired
    private UserDao userDao;

    @ParameterizedTest
    @CsvSource({"1,zs,zs,60","2,ls,ls,120"})
    public void testSave(Long id, String name, String pwd, Long timeout) {
        userDao.save(new UserHash(id,name,pwd,timeout));
    }
}
