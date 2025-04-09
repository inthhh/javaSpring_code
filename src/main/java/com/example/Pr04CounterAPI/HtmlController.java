package com.example.Pr04CounterAPI;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {
    @Autowired
    private Counter counter;
    // 자바 int 타입 필드 : 자동으로 0으로 초기화됨
    
    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("count", counter.getCount());
        return "index";
    }
}