package com.ssydx.website.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IWebContext;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

import com.ssydx.website.app.config.AccessLimit;
import com.ssydx.website.app.dao.ProductMapper;
import com.ssydx.website.app.dao.RedisDao;
import com.ssydx.website.app.domain.MiaoshaProduct;
import com.ssydx.website.app.domain.User;
import com.ssydx.website.app.redis.ProductLsRedis;
import com.ssydx.website.app.service.MiaoshaService;
import com.ssydx.website.app.vo.ProductVo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ProductController {
    @Autowired
    private MiaoshaService productService;
    @Autowired
    private RedisDao redisDao;
    @Autowired
    private ThymeleafViewResolver thymeleafViewResolver;

    @GetMapping("/product")
    @AccessLimit
    public ResponseEntity<String> product(HttpServletRequest request, HttpServletResponse response, User user) {
        String html = redisDao.get(ProductLsRedis.prefix, "", String.class);
        if (html != null) {
            return ResponseEntity.ok().body(html);
        }
        List<MiaoshaProduct> productVos = productService.getProductList();
        Context context = new Context(request.getLocale());
        context.setVariables(Map.of("user",user,"productLs",productVos));
        html = thymeleafViewResolver.getTemplateEngine().process("product", context);
        if (html != null) {
            redisDao.set(ProductLsRedis.prefix, "", html, ProductLsRedis.expiredSeconds);
        }
        return ResponseEntity.ok().body(html);
    }
    @GetMapping("/product/{id}")
    @ResponseBody
    @AccessLimit
    public ProductVo productdetail(@PathVariable("id") Long id, User user,Model model) {
        MiaoshaProduct miaoshaProduct = productService.getProductById(id);
        long now = System.currentTimeMillis();
        long start_date = miaoshaProduct.getStart_date().getTime();
        long end_date = miaoshaProduct.getEnd_date().getTime();
        int toStartTime;
        if (now > end_date) {
            toStartTime = -1;
        } else if (now < start_date) {
            toStartTime = (int)((start_date - now)/1000);
        } else {
            toStartTime = 0;
        }
        int toEndTime = (int)((end_date - now)/1000);
        ProductVo productVo = new ProductVo();
        productVo.setMiaoshaProduct(miaoshaProduct);
        productVo.setToEndTime(toEndTime);
        productVo.setToStartTime(toStartTime);
        productVo.setUser(user);
        return productVo;
    }
}
