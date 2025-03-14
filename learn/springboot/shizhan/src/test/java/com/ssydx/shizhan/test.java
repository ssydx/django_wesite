package com.ssydx.shizhan;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.ssydx.shizhan.dao.UserMapper;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class test {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void run() {
        System.out.println(userMapper.findById(1));
    }
}
