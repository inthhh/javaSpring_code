# 📍 Java Spring 연습
Java Spring/Springboot 수업 내용과 개인적 연습 기록을 담는 공간입니다.<br>
[ 참고 도서 : 점프 투 스프링부트3 (이지스퍼블리싱) ]

- 실습 문제 자료 : https://codinggangsa.notion.site/3-70f16435c54649ef870d9e27028da48d
- 자판기 (with REST API) : https://github.com/inthhh/Spring_Vending

### 🪾 Branch
- ex12_H2DB_Test : 테스트 코드 실습
- ex28_security01 : 로그인 보안

## JPA란?

> Java Persistence API
> 
> 
> 자바에서 **객체(Entity)** 와 **DB 테이블**을 연결해서, **SQL 없이도 DB를 조작할 수 있게 해주는 기술**.
> 
> - SQL 안 써도 됨
> - 객체처럼 다룸 (멤버는 자바 클래스)

```java
@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long>
```

`MemberEntity` 엔티티의 데이터를 DB에서 CRUD(조회, 저장, 삭제 등) 할 수 있게 메서드를 제공하고 도와주는 **JPA 리포지토리**

### `@Repository`

- 스프링한테 "이건 DB 접근을 담당하는 컴포넌트야!" 라고 알려주는 애너테이션.

### `extends JpaRepository<MemberEntity, Long>`

- `JpaRepository`는 JPA가 제공하는 **기본 CRUD 메서드가 다 들어있는 인터페이스**
- < **엔티티 클래스** (예: member 테이블), 엔티티의 **기본키(PK) 타입 >**
