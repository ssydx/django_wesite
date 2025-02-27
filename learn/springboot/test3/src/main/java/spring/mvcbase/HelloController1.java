package spring.mvcbase;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController1 {
    @RequestMapping("page1")
    public String redirect() {
        return "viewpage1";
    }
    @RequestMapping("page1/page1-1")
    public String display() {
        return "viewpage1-1";
    }
}
