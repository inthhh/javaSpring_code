package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String main(){
//        return "index.html"; // static에서는 이렇게 쓰지만
        return "index"; // 타임리프에서는 알아서 타입을 내려줌 (랜더해서 내려줌)
    }
    
    @GetMapping("/index")
    public String index1(Model model){
        // Model 클래스 : 스프링에서 데이터를 담아 전달하는 용도의 클래스 객체
        model.addAttribute("name_text", "<ins>홍길동</ins>");
        model.addAttribute("name_html", "<ins>홍길동</ins>");
        System.out.println("name_text = " + model.getAttribute("name_text"));
        System.out.println("name_html = " + model.getAttribute("name_html"));
        return "index";
    }
    
    @GetMapping("/index2")
    public String index2(Model model){
        model.addAttribute("address_null", "123");
        return "index2";
    }
}
