package com.mm.splr.controller;

import com.mm.splr.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Hello {

    @RequestMapping(  "/hello")
    public String index(ModelMap map) {
        map.addAttribute("name", "Hello Thymeleaf From Spring Boot");
        return "hello";
    }

    @RequestMapping("/if")
    public String ifunless(ModelMap map) {
        map.addAttribute("flag", "yes");
        return "if";
    }

    @RequestMapping("/switch")
    public String switchcase(ModelMap map) {
        map.addAttribute("status", "doing");
        return "switch";
    }

    @RequestMapping("/list")
    public String list(ModelMap map) {
        List<User> list=new ArrayList();
        User user1=new User("spring",12,"123456");
        User user2=new User("boot",6,"123456");
        User user3=new User("Thymeleaf",66,"123456");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        map.addAttribute("users", list);
        return "list";
    }
    @RequestMapping("/inline")
    public String inline(ModelMap map) {
        map.addAttribute("fontSize", "20px");
        map.addAttribute("color", "yellow");
        map.addAttribute("userName", "admin");

        return "inline";
    }
    @RequestMapping("/i18n")
    public String i18n() {
        return "i18n";
    }

    @RequestMapping("/object")
    public String test1(HttpServletRequest request){
        request.setAttribute("request", "spring boot");
        request.getSession().setAttribute("session", "admin session");
        request.getServletContext().setAttribute("servletContext","Thymeleaf servletContext");
        return "baseobject";
    }

    @RequestMapping("/insert")
    public String insert() {
        return "insert";
    }

    @RequestMapping("/layout")
    public String layout() {
        return "layout";
    }

    @RequestMapping("/layout/index")
    public String index() {
        return "layout/index";
    }
}
