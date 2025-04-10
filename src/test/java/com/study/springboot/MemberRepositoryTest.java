package com.study.springboot;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest // 스프링 부트 전체를 실행시켜서 통합 테스트할 수 있게 함
    // 실제 서비스랑 비슷한 환경으로 테스트 가능
class MemberRepositoryTest {
    @Autowired // MemberRepository를 스프링이 자동으로 주입해줌
    MemberRepository memberRepository;
    
    @BeforeAll // static 메소드여야 함!! 모든 테스트 실행 전에 딱 한 번 실행(초기 설정)
    static void setup(){
        System.out.println("@BeforeAll");
    }
    @BeforeEach // @Test 메소드 호출시마다 한번 수행 (매 테스트마다 초기화 작업이 필요할 때)
    void init(){
        System.out.println("@BeforeEach");
    }
    
    @Test // 테스트 메소드 (단위 메소드, 실행 가능)
    @DisplayName("Save 테스트") // 테스트 이름
    public void save() {
        System.out.println("save()");
        
        memberRepository.save(
                new MemberEntity(null, "hong", "1234", "홍길동", "ROLE_USER",
                        LocalDate.parse("2025-04-10")));
        List<MemberEntity> list = memberRepository.findAll();
        
        // 단정함수(assert function) - org.junit.jupiter.api
        assertEquals(1, list.size());
        // assertEquals(예상값, 실제값); 일치 시 true
    }
    
    @Test
    @DisplayName("findById 테스트")
    public void findById(){
        memberRepository.save(
                new MemberEntity(null, "hong", "1234", "홍길동", "ROLE_USER",
                        LocalDate.parse("2025-04-10")));
        // 1. id=1L인 회원을 찾아옴. 값이 있을 수도 있고, 없을 수도 있기 때문에 Optional
        Optional<MemberEntity> optional = Optional.ofNullable(memberRepository.findById(1L)
                .orElseThrow(() -> new AssertionError("해당 ID의 멤버가 없습니다")));
        // 2. optional이 존재하지 않으면 실패(오류)
        // 2. optional이 존재하면 실행. unwrapped는 진짜 회원 엔티티 객체
        optional.ifPresent(unwrapped->{
            System.out.println("unwrapped : "+unwrapped.getUserName());
            assertEquals("이밍밍", unwrapped.getUserName());
        });
    }
    
    @Test
    @DisplayName("count 테스트")
    public void count(){
        Long count = memberRepository.count(); //select count(*) from member
        assertEquals(3, count);
    }
    @Test
    @DisplayName("쿼리 테스트")
    public void query() {
        //JPA 쿼리함수 패턴 : find + By + 필드이름 + And + 필드이름
//        List<MemberEntity> list =
//                memberRepository.findAll();
//        assertEquals(3, list.size());
        
        List<MemberEntity> list1 =
                //사용자 정의 쿼리 함수
                memberRepository.findByUserId("hong");
        assertEquals(1, list1.size(), "list1 size 검증 실패");
        
        List<MemberEntity> list2 =
                //사용자 정의 쿼리 함수
                memberRepository.findFirst5ByUserIdAndUserNameOrderByIdDesc(
                        "hong", "홍길동"
                );
        assertEquals(1, list2.size(),"list1 size 검증 실패");
    }

}