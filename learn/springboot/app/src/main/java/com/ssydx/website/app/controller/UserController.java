package com.ssydx.website.app.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssydx.website.app.dao.SessionDao;
import com.ssydx.website.app.domain.Session;
import com.ssydx.website.app.domain.UserHash;
import com.ssydx.website.app.service.UserService;
import com.ssydx.website.app.util.CookieUtil;
import com.ssydx.website.app.vo.UserVo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private SessionDao sessionDao;

    @GetMapping("login")
    public String login(Model model) {
        model.addAttribute("login", new UserVo());
        return "login";
    }
    @PostMapping("login")
    public String login(UserVo userVo,HttpServletRequest request,  HttpServletResponse response, RedirectAttributes redirectAttributes) {
        String sessionId = CookieUtil.getCookieValue(request);
        // 如果存在会话ID且该用户与redis会话中的用户匹配
        if (sessionId != null && sessionId.length() > 0) {
            Optional<Session> optionalUserHash = sessionDao.findById(sessionId);
            // 如果redis中存在该会话ID
            if (optionalUserHash.isPresent()) {
                UserHash userHash = optionalUserHash.get().getUserHash();
                // 如果存在用户信息
                if (userHash != null) {
                    // 更新会话，包括redis和cookie
                    CookieUtil.addSessionId(response, sessionId);
                    sessionDao.save(new Session(sessionId, userHash, 1800L));
                    // 如果本次登录用户与redis中的用户相同
                    if (userVo.getName().equals(userHash.getName()) && userVo.getPwd().equals(userHash.getPwd())) {
                        // 直接重定向
                        return "redirect:/other";
                    }
                }
            }
        }
        // 完整验证
        String flag = userService.isExistUser(userVo);
        if (flag.equals("验证成功")) {
            sessionId = UUID.randomUUID().toString();
            CookieUtil.addSessionId(response, sessionId);
            sessionDao.save(new Session(sessionId, new UserHash(userVo.getName(),userVo.getPwd(),3600L), 1800L));
            return "redirect:/other";
        } else {
            redirectAttributes.addFlashAttribute("flag",flag);
            return "redirect:/login";
        }
    }
    @GetMapping("/other")
    public String other() {
        return "other";
    }
}
