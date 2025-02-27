package spring.mvcbase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController2 {
    @Autowired
    EmployeeDao2 e;
    @RequestMapping(value = "/viewempls/{pageid}")
    public String getEmpls(@PathVariable int pageid, Model m) {
        int num = 3;
        int offset = (pageid - 1) * num;
        m.addAttribute("empls", e.getByPage(offset, num));
        return "viewempls";
    }
}
