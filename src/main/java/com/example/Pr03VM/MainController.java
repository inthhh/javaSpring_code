package com.example.Pr03VM;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {
    
    private List<ProductDto> productList = new ArrayList<>();
    
    @GetMapping("/")
    public String main(){
        return "main";
    }
    
    @GetMapping("/add")
    public String add(){
        return "add";
    }
    
    @GetMapping("/edit")
    public String edit(@RequestParam("index") int index) {
        return "edit";
    }
    
    @PostMapping("/add")
    public String add(@RequestParam("name") String name,
                      @RequestParam("price") int price,
                      @RequestParam("date") LocalDate date){
        productList.add(new ProductDto(name, price, date));
        return "main";
    }
    
    @PostMapping("/edit")
    public String edit(@RequestParam("index") int index,
                       @RequestParam("name") String name,
                      @RequestParam("price") int price,
                      @RequestParam("date") LocalDate date){
        productList.set(index, new ProductDto(name, price, date));
        return "main";
    }
    
    @GetMapping("/product")
    public String product(@RequestParam int index){
        return "main";
    }
}