package com.example.Pr03VM;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String main(Model model) {
        model.addAttribute("productList", productList); // 리스트를 넘겨줍니다.
        return "main";
    }
    
    @GetMapping("/add")
    public String add(){
        return "add";
    }
    
    @GetMapping("/edit")
    public String edit(@RequestParam("index") int index, Model model) {
        ProductDto product = productList.get(index);  // 리스트에서 해당 항목 꺼냄
        model.addAttribute("product", product);       // 템플릿에서 사용할 변수로 등록
        model.addAttribute("index", index);           // hidden으로 index도 같이 넘겨줄 수 있음
        return "edit";
    }
    
    @PostMapping("/add")
    public String add(@RequestParam("name") String name,
                      @RequestParam("price") int price,
                      @RequestParam("date") LocalDate date){
        productList.add(new ProductDto(name, price, date));
        return "redirect:/"; // 리다이렉트 -> 뷰 및 url이 모두 변경
    }
    
    @PostMapping("/edit")
    public String edit(@RequestParam("index") int index,
                       @RequestParam("name") String name,
                      @RequestParam("price") int price,
                      @RequestParam("date") LocalDate date){
        productList.set(index, new ProductDto(name, price, date));
        return "redirect:/";
    }
    
    @GetMapping("/product")
    public String product(@RequestParam int index){
        return "main";
    }
    
    @GetMapping("/remove")
    public String remove(@RequestParam int index, Model model) {
        productList.remove(index);
        model.addAttribute("productList", productList); // 리스트를 넘겨줍니다.
        return "main";
    }
}