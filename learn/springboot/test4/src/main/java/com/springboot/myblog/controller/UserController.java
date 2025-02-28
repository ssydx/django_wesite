package com.springboot.myblog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.springboot.myblog.entity.User;
import com.springboot.myblog.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserRepository userRepository;
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping("/")
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
    @GetMapping("/{login}")
    public User findOne(@PathVariable String login) {
        User res = userRepository.findByLogin(login);
        if (res == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"该作者不存在");
        }
        return res;
    }
}