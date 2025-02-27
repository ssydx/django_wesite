package spring.mvcbase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {
    @Autowired  
    EmployeeDao dao;
    // 查
    @RequestMapping("/viewemp")  
    public String viewemp(Model m){  
        List<Employee> list=dao.getEmps();  
        m.addAttribute("list",list);
        return "viewemp";  
    }
    // 增
    @RequestMapping("/empform")  
    public String showform(Model m){  
        m.addAttribute("emp", new Employee());
        return "empform"; 
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("emp") Employee e){  
        dao.insert(e);
        return "redirect:/viewemp"; 
    }
    // 删
    @RequestMapping(value = "/deleteemp/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        dao.delete(id);
        return "redirect:/viewemp";  
    } 
    // 改
    @RequestMapping(value="/editemp/{id}")  
    public String edit(@PathVariable int id, Model m){  
        Employee e=dao.getById(id);
        m.addAttribute("emp", e);
        return "empeditform";
    }
    @RequestMapping(value="/editemp/editsave",method = RequestMethod.POST)  
    public String editsave(@ModelAttribute("emp") Employee e){  
        dao.update(e);  
        return "redirect:/viewemp";  
    } 

}
