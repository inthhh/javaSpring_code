package com.example.Pr01Counter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final Counter counter;
    
    @GetMapping("/")
    public String main(){
        return "index";
    }
    
    @GetMapping("/plus")
    public String plus(Model model){
        counter.setCount(counter.getCount()+1);
        model.addAttribute("count", counter.getCount());
        return "index";
    }
    
    @GetMapping("/minus")
    public String minus(Model model){
        counter.setCount(counter.getCount()-1);
        model.addAttribute("count", counter.getCount());
        return "index";
    }
}
