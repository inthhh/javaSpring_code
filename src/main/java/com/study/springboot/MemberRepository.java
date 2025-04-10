package com.study.springboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    
    // JpaRepository 기본함수
    // 1. findAll() : SQL문을 실행함
    // 2. save() : SQL insert문과 update문을 실행함. id값이 없으면 추가, 있으면 수정
    // 3. delete() : SQL delete 수행
    
    // 사용자 정의 JPA 함수들을 추가해서 사용한다.
    // 쿼리 메소드
    //findBy열이름() : SQL - select 열이름 from 테이블 문으로 실행
    //  예) findById(2L) : select * from member where id=2
    //  예) findByUserId("hong") : select * from where user_id='hong'
    
    List<MemberEntity> findByUserId(String userId);
    List<MemberEntity> findFirst5ByUserIdAndUserNameOrderByIdDesc(
            String userid, String username
    );
}
