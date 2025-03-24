package com.ssydx.securtiy.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssydx.securtiy.domain.User;
import com.ssydx.securtiy.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class controller {
    @Autowired
    private UserService userService;
    
    @RequestMapping({"/","index"})
    // @GetMapping({"/","index"})
    public String index() {
        return "index";
    }
    
    @GetMapping("/toLogin")
    public String login(HttpServletRequest request, Model model) {
        Exception exception = (Exception) request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        if (exception != null) {
            model.addAttribute("loginerror", true);
            model.addAttribute("message", exception.getMessage());
        }
        return "views/login";
    }
    @GetMapping("/toLogout")
    public String logout() {
        return "views/logout";
    }

    @GetMapping("/level1/{id}")
    public String level1(@PathVariable("id") int id) {
        return "views/level1/" + id;
    }
    @GetMapping("/level2/{id}")
    public String level2(@PathVariable("id") int id) {
        return "views/level2/" + id;
    }
    @GetMapping("/level3/{id}")
    public String level3(@PathVariable("id") int id) {
        return "views/level3/" + id;
    }

    @GetMapping("/user/{name}")
    public String userinfo(Model model, @PathVariable("name") String username) {
        model.addAttribute("user", userService.getUser(username));
        return "views/user/info";
    }
    @GetMapping("/user/add")
    public String useradd() {
        return "views/user/add";
    }
    @PostMapping("/user/add")
    public String useradd(@RequestParam("username") String username, @RequestParam("password") String password,@RequestParam("role") String role) {
        userService.createUser(new User(username, password, role, null));
        return "redirect:/user/" + username;
    }
    @GetMapping("/user/del")
    public String userdel() {
        return "views/user/del";
    }
    @PostMapping("/user/del")
    public String userdel(@RequestParam("username") String username) {
        userService.deleteUser(username);
        return "redirect:/";
    }
    @GetMapping("/user/upd")
    public String userupd() {
        return "views/user/upd";
    }
    @PostMapping("/user/upd")
    public String userupd(@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("role") String role) {
        userService.updateUser(new User(username, password, role, null));
        return "redirect:/";
    }
    @GetMapping("/user/info1")
    @ResponseBody
    public Object userinfo1() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("=============>class:" + authentication.getClass().getSimpleName());
        return authentication;
    }
    @GetMapping("/user/info2")
    @ResponseBody
    public Object userinfo2(Principal principal) {
        System.out.println("=============>class:" + principal.getClass().getSimpleName());
        return principal;
    }

}
