package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
//    @GetMapping("/")
    //@ResponseBody //JSON(XML)로 응답할 때 주로 사용
    @RequestMapping(value = "/", method = RequestMethod.GET) // getmapping + responsebody
    public String main(){
        return "index.html"; //index.html파일로 응답
    }
}