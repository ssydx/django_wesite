package spring.mvcbase;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController2 {
    @RequestMapping("page2")
    public String display() {
        return "viewpage2";
    }
}
