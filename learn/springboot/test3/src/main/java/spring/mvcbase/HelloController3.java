package spring.mvcbase;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController3 {
    @RequestMapping("page3")
    public String display(HttpServletRequest req,Model m) {
        if (req.getParameter("username").equals("ssydx") && req.getParameter("userpwd").equals("123456")) {
            m.addAttribute("username", req.getParameter("username"));
            return "userpage";
        } else {
            return "errorpage";
        }
    }
}
