package com.study.springboot;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 클래스의 모든 응답이 문자열로 선언됨 (JSON)
@RequestMapping("/api/v1") // 모든 경로가 ~/api/v1부터 시작함
public class ApiController {
    // http://localhost:8080/api/v1/login
    @RequestMapping("/login")
    public String login(){
        return "login 함수";
    }
}
