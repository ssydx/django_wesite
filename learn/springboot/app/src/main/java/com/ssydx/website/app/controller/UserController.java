package com.ssydx.website.app.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssydx.website.app.dao.RedisDao;
import com.ssydx.website.app.domain.User;
import com.ssydx.website.app.redis.SessionRedis;
import com.ssydx.website.app.service.UserService;
import com.ssydx.website.app.util.CookieUtil;
import com.ssydx.website.app.vo.UserVo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/login")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisDao redisDao;

    @GetMapping
    public String login(Model model) {
        model.addAttribute("login", new UserVo());
        return "login";
    }
    @PostMapping
    public String login(UserVo userVo,HttpServletRequest request,  HttpServletResponse response, RedirectAttributes redirectAttributes) {
        String sessionId = CookieUtil.getCookieValue(request);
        // 如果存在会话ID且该用户与redis会话中的用户匹配
        if (sessionId != null && sessionId.length() > 0) {
            User user = redisDao.get(SessionRedis.prefix, sessionId, User.class);
            if (user != null) {
                // 如果本次登录用户与redis中的用户相同
                if (userVo.getName().equals(user.getUserName()) && userVo.getPwd().equals(user.getUserPwd())) {
                    // 更新会话，包括redis和cookie
                    CookieUtil.addSessionId(response, sessionId);
                    redisDao.reset(SessionRedis.prefix, sessionId, SessionRedis.expiredSeconds);
                    // 直接重定向
                    return "redirect:/product";
                }
            }
        }
        // 完整验证
        String flag = userService.isExistUser(userVo);
        if (flag.equals("验证成功")) {
            sessionId = UUID.randomUUID().toString();
            CookieUtil.addSessionId(response, sessionId);
            redisDao.set(SessionRedis.prefix, sessionId, userService.getUser(userVo.getName()), SessionRedis.expiredSeconds);
            return "redirect:/product";
        } else {
            redirectAttributes.addFlashAttribute("flag",flag);
            return "redirect:/login";
        }
    }
}
