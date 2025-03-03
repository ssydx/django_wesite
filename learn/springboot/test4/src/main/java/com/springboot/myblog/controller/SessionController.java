package com.springboot.myblog.controller;

import java.util.Objects;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.myblog.domain.SessionQuery;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@RequestMapping("/session")
@RestController
public class SessionController {
    private boolean authenticate(SessionQuery sessionQuery) {
        return Objects.equals(sessionQuery.getUsername(), "admin") && Objects.equals(sessionQuery.getPassword(), "123456");
    }
    private void certificate(HttpServletResponse response) {
        Cookie cookie = new Cookie("sessionid", "test-token");
        response.addCookie(cookie);
    }
    @PostMapping
    public String login(@RequestBody SessionQuery sessionQuery, HttpServletResponse response) {
        if (authenticate(sessionQuery)) {
            certificate(response);
            return "success";
        }
        return "failed";
    }
}
