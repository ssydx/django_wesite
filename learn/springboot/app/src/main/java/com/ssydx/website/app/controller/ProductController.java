package com.ssydx.website.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ssydx.website.app.config.AccessLimit;
import com.ssydx.website.app.dao.ProductMapper;

@Controller
public class ProductController {
    @Autowired
    private ProductMapper productMapper;

    @GetMapping("/product")
    @AccessLimit
    public String product(Model model) {
        model.addAttribute("productLs", productMapper.findAll());
        return "product";
    }
}
