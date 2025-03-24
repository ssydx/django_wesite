package com.ssydx.securtiy.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssydx.securtiy.common.Result;

@RestController
@RequestMapping("/rest")
public class restcontroller {
    @GetMapping("/query")
    @PreAuthorize(value = "hasRole('vip1')")
    public Result query() {
        return new Result<>(200, "查询成功");
    }
    @GetMapping("/add")
    @PreAuthorize(value = "hasRole('vip2')")
    public Result add() {
        return new Result<>(200, "新建成功");
    }
    @GetMapping("/del")
    @PreAuthorize(value = "hasRole('vip3')")
    public Result del() {
        return new Result<>(200, "删除成功");
    }
}
