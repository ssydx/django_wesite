package spring.mvcbase;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/people")
@Controller
public class PeopleController {
    @RequestMapping("/bookingForm")
    public String bookingForm(Model m) {
        People p = new People();
        // 向页面传入模型
        m.addAttribute("people", p);
        return "peoplepage";
    }
    @RequestMapping("/submitForm")
    // 将接收的people属性解析到模型对象上，页面上引用使用people，方法内则采用p
    public String submitForm(@ModelAttribute("people") People p) {
        return "confirm";
    }
}
