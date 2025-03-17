package com.ssydx.website.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.ssydx.website.app.domain.UserHash;
import com.ssydx.website.app.service.UserService;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class TestService {
    @Autowired
    private UserService userService;

    @Test
    public void testUserService() {
        try {
            UserHash userHash = userService.getUserHash(3L);
            System.out.println(userHash);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
