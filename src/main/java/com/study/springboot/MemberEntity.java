package com.study.springboot;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity // (엔티티 : DB 테이블과 매핑되는 클래스)
@Table(name="member")
@Getter
// @Setter - 비추 : 엔티티는 가능한 한 불변한 상태로 유지하는 것이 좋고,
// id 등 DB에서 수정되면 안되는 데이터들도 있으므로
// setter가 필요하다면 직접 메소드를 생성하여 필요한 개체만 접근할 수 있게 해라.
@Builder  //객체생성시 사용 - 생성자함수 대체
@AllArgsConstructor
@NoArgsConstructor
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="user_id")
    private String userId;
    @Column(name="user_pw")
    private String userPw;
    @Column(name="user_name")
    private String userName;
    @Column(name="user_role")
    private String userRole;
    @Column
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate joindate;
    
    public void update(String userId, String userPw, String userName,
                       String userRole){
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.userRole = userRole;
    }
}
