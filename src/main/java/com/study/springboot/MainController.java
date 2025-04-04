package com.study.springboot;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MainController {
    @RequestMapping("/")
    public String main(){
        return "index";
    }
    
    @PostMapping("/calculate")
    @ResponseBody
    public ResDto calculate(@RequestBody ReqDto req){
        Number n1 = req.getNum1();
        Number n2 = req.getNum2();
        System.out.println(n1);
        System.out.println(n2);
        double ans = 0;
        switch (req.getOperator()){
            case "+":
                ans = n1.doubleValue() + n2.doubleValue();
                break;
            case "-":
                ans = n1.doubleValue() - n2.doubleValue();
                break;
            case "*":
                ans = n1.doubleValue() * n2.doubleValue();
                break;
            case"/":
                ans = n1.doubleValue() / n2.doubleValue();
                break;
        }
        ResDto resDto = new ResDto();
        resDto.setResult(ans);
        return resDto;
    }
}
