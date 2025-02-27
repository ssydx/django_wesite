package spring.mvcbase;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController4 {
    @RequestMapping("page4")
    public String display(@RequestParam("username") String name, @RequestParam("userpwd") String pwd ,Model m) {
        if (name.equals("ssydx") && pwd.equals("123456")) {
            m.addAttribute("username", name);
            return "userpage";
        } else {
            return "errorpage";
        }
    }
}
