package com.ssydx.test5.controller;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssydx.test5.dto.AuthorDto;
import com.ssydx.test5.entity.AuthorEntity;
import com.ssydx.test5.service.ArticleService;
import com.ssydx.test5.service.AuthorService;


@Controller
public class IndexController {
    @RequestMapping(path = "/",method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("name","ssydx");
        model.addAttribute("author", new AuthorDto().setName("十三月的雪"));
        return "index";
    }
    @GetMapping("/rest")
    @ResponseBody
    public ResponseEntity<String> restIndex() {
        return new ResponseEntity<String>("欢迎访问",null,HttpStatus.OK);
    }
    @Autowired
    private AuthorService authorService;
    @Autowired
    private ArticleService articleService;
    @PostMapping("/addAuthor")
    public String addAuthor(@ModelAttribute AuthorDto authorDto) {
        Long i = authorService.addAuthor(authorDto);
        System.out.println("值为" + i);
        return "redirect:listAuthor";
    }
    @PostMapping("/rest/addAuthor")
    @ResponseBody
    public ResponseEntity<Map<String,String>> restAddAuthor(@RequestBody AuthorDto authorDto) {
        authorService.addAuthor(authorDto);
        return new ResponseEntity<Map<String,String>>(Map.of("tip","增加成功"),null,HttpStatus.OK);
    }
    @GetMapping("/listAuthor")
    public String listAuthor(Model model) {
        model.addAttribute("authors", authorService.getAllAuthor());
        return "listAuthor";
    }
    @GetMapping("/rest/listAuthor")
    @ResponseBody
    public ResponseEntity<List<AuthorEntity>> restListAuthor(Model model) {
        return new ResponseEntity<List<AuthorEntity>>(authorService.getAllAuthor(),null,HttpStatus.OK);
    }
    @DeleteMapping("/listAuthor/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return "redirect:listAuthor";
    }
    @DeleteMapping("/rest/deleteAuthor/{id}")
    @ResponseBody
    public ResponseEntity<Map<String,String>> restDeleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return new ResponseEntity<Map<String,String>>(Map.of("tip","删除成功"),null,HttpStatus.OK);
    }
}
