package com.study.springboot;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    @Autowired
    private MemberRepository memberRepository;
    
    @GetMapping("/")
    public String main(Model model){
        System.out.println(memberRepository);
        
        // 데이터 삽입
        memberRepository.save(new MemberEntity(null, "hong", "1234", "홍길동","ROLE_USER",
                LocalDate.now()));
//        memberRepository.save(new MemberEntity(Long.valueOf(2), "tom", "2341", "톰아저씨","ROLE_USER",
//                LocalDate.now()));
        
        List<MemberEntity> list = memberRepository.findAll();
        System.out.println(list.size());
        
        model.addAttribute("list", list);
        
        return "index";
    }
}
