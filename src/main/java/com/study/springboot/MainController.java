package com.study.springboot;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class MainController {
    @GetMapping("/")
    public String loginform(){
        return "login_form";
    }
    
    @RequestMapping("/loginForm")
    public String loginForm(){
        return "login_form";
    }
    
    @RequestMapping("/loginAction1")
    public String loginAction1(HttpServletRequest req){
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        return "loginResult";
    }
}
