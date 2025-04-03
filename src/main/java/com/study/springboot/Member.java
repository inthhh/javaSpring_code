package com.study.springboot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
//@AllArgsConstructor
public class Member {
    private String username;
    private String password;
    
    public Member(final String hong, final String number) {
    }
}