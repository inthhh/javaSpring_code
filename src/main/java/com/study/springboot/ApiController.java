package com.study.springboot;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 클래스의 모든 응답이 문자열로 선언됨 (JSON)
@RequestMapping("/api/v1") // 모든 경로가 ~/api/v1부터 시작함
public class ApiController {
    // http://localhost:8080/api/v1/login
    @RequestMapping("/hello")
    public String hello(){
        return "api 서버 시작";
    }
    
    // clinet <-> server
    //        JSON
    @PostMapping("/login")
    public ResDto login(@RequestBody ReqDto reqDto) {
        System.out.println("username = " + reqDto.getUsername());
        System.out.println("password = " + reqDto.getPassword());
        
        return null;
    }
}
