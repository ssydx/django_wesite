package com.ssydx.shizhan.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssydx.shizhan.domain.User;
import com.ssydx.shizhan.exception.MiaoshaException;
import com.ssydx.shizhan.redis.RedisUtil;
import com.ssydx.shizhan.redis.UserKey;
import com.ssydx.shizhan.result.CodeMsg;
import com.ssydx.shizhan.result.Result;
import com.ssydx.shizhan.service.UserService;
import com.ssydx.shizhan.util.MD5Util;
import com.ssydx.shizhan.vo.LoginVo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final RedisUtil redisUtil;
    public UserController(UserService userService, RedisUtil redisUtil) {
        this.userService = userService;
        this.redisUtil = redisUtil;
    }
    @GetMapping("/login")
    public String toLogin() {
        return "login";
    }
    @GetMapping(value = "/verifyCode")
    @ResponseBody
    public void getLoginVerifyCode(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String token = CookieUtil.getSessionId(request, response);
        BufferedImage image = userService.createVerifyCode(token);
        OutputStream out = response.getOutputStream();
        ImageIO.write(image, "JPEG", out);
        out.flush();;
        out.close();
    }
    @PostMapping("/proLogin")
    @ResponseBody
    public Result<Boolean> proLogin(HttpServletRequest request,HttpServletResponse response, LoginVo loginVo) {
        String token = CookieUtil.getCookieValue(request, UserKey.COOKIE_NAME_TOKEN);
        if (token != null) {
            if (!userService.checkVerifyCode(token,loginVo.getVercode())) {
                return Result.error(CodeMsg.REQUEST_ILLEGAL);
            }
            User user = getByToken(response, token);
            if (user != null && user.getId().toString().equals(loginVo.getMobile()) && MD5Util.passToDbPass(loginVo.getPassword(),user.getSalt()).equals(user.getPassword())) {
                return Result.success(true);
            }
        }
        try {
            User user = userService.login(loginVo);
            addSession(response, token, user);
            return Result.success(true);
        } catch (MiaoshaException e) {
            return Result.error(e.getCodeMsg());
        }
    }
    private void addSession(HttpServletResponse response, String token, User user) {
        redisUtil.set(UserKey.token, token, user);
        CookieUtil.addSessionId(response, token);
    }
    public User getByToken(HttpServletResponse response, String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        User user = redisUtil.get(UserKey.token, token, User.class);
        if (user != null) {
            addSession(response, token, user);
        }
        return user;
    }
}
