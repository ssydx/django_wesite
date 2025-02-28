package spring.mvcbase;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
    @RequestMapping("studentadd")
    public String get(Model m) {
        m.addAttribute("student", new Student());
        return "studentadd";
    }
    @RequestMapping("studentview")
    public String get(@Valid @ModelAttribute("student") Student s, BindingResult br) {
        if (br.hasErrors()) {
            return "studentadd";
        } else {
            return "studentview";
        }
    }
}
