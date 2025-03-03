package com.springboot.myblog.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/log")
@Slf4j
@RestController
public class LogController {

    @GetMapping
    public String justShowSomeLog() {
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
        return "查看你的控制台";
    }
}
