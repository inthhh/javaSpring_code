package com.study.springboot;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


//연습문제
// JPA 메소드 쿼리
//1. member 테이블 안에 암호가 "1234"인 회원이 있는지 테스트 하시오.
//2. 23년도 3월에 가입한 회원의 수가 1인지 테스트하시오.
//3. "lee"라는 아이디로 회원가입하고자 할때, 아이디 중복인지 테스트하시오.
// JPQL or NativeQuery
//4. "tom"이라는 아이디의 회원정보를 수정하고, 잘 수정되었는지 테스트하시오.
//    톰아저씨 -> 마이클, 암호 -> 3456

@SpringBootTest
public class ExampleTest {
    @Autowired // MemberRepository를 스프링이 자동으로 주입해줌
    MemberRepository memberRepository;
    
    @Test
    @DisplayName("문제1")
    public void ex01() {
        boolean isExists = memberRepository.existsByUserPw("1234");
        assertEquals( true, isExists);
    }
    @Test
    @DisplayName("문제2")
    public void ex02() {
        LocalDate start = LocalDate.of(2025, 4, 1);
        LocalDate end = LocalDate.of(2025, 4, 30);
        boolean isExists = memberRepository.existsByJoindateBetween(start, end);
        assertEquals( true, isExists);
    }
    @Test
    @DisplayName("문제3")
    public void ex03(){
        boolean isExists = memberRepository.existsByUserId("hong");
        assertEquals(true, isExists);
        
    }
    @Test
    @DisplayName("문제3-2")
    public void ex03_2(){
        boolean isExists = memberRepository.existsByUserId("lee");
        assertEquals(true, isExists);
    }
    @Test
    @DisplayName("문제4")
    public void ex04(){
        int count = memberRepository.updateByUserId_Native(
                "tom", "마이클", "3456");
        assertEquals(1, count);
        
        Optional<MemberEntity> optional = memberRepository.findByUserId("tom");
        optional.ifPresentOrElse( unwrapped -> {
            assertEquals("마이클", unwrapped.getUserName());
        }, () -> {
            fail("UserId(\"tom\") 엔티티를 찾지 못했습니다.");
        } );
    }
}
