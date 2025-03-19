package com.ssydx.website.app.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssydx.website.app.config.AccessLimit;
import com.ssydx.website.app.dao.RedisDao;
import com.ssydx.website.app.domain.User;
import com.ssydx.website.app.redis.SessionRedis;
import com.ssydx.website.app.service.UserService;
import com.ssydx.website.app.util.CookieUtil;
import com.ssydx.website.app.vo.UserVo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisDao redisDao;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("login", new UserVo());
        return "login";
    }
    @GetMapping("/vercode")
    @ResponseBody
    public byte[] setVercode(HttpServletRequest request,
    HttpServletResponse response) throws IOException {
        String sessionId = CookieUtil.getSessionId(request);
        if (sessionId == null) {
            sessionId = CookieUtil.setSessionId(response);
        }
        BufferedImage image = userService.setVercode(sessionId);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "jpeg", baos);
        return baos.toByteArray();
    }
    @PostMapping("/login")
    public String login(UserVo userVo,HttpServletRequest request,  HttpServletResponse response, RedirectAttributes redirectAttributes) {
        String sessionId = CookieUtil.getSessionId(request);
        if (sessionId == null || !userService.checkVercode(sessionId, userVo.getVercode())) {
            return "redirect:/user/login";
        }
        User user = redisDao.get(SessionRedis.prefix, sessionId, User.class);
        if (user != null && userVo.getName().equals(user.getUserName()) && userVo.getPwd().equals(user.getUserPwd())) {
            // 更新会话，包括redis和cookie
            CookieUtil.resetSessionId(response, sessionId);
            redisDao.reset(SessionRedis.prefix, sessionId, SessionRedis.expiredSeconds);
            // 直接重定向
            return "redirect:/product";
        }
        // 完整验证
        String flag = userService.isExistUser(userVo);
        System.out.println(flag);
        if (flag.equals("验证成功")) {
            sessionId = CookieUtil.setSessionId(response);
            redisDao.set(SessionRedis.prefix, sessionId, userService.getUser(userVo.getName()), SessionRedis.expiredSeconds);
            return "redirect:/product";
        } else {
            redirectAttributes.addFlashAttribute("flag",flag);
            return "redirect:/user/login";
        }
    }
    @GetMapping("/info")
    @AccessLimit
    public String info(Model model, User user) {
        model.addAttribute("user", user);
        return "info";
    }
}
