package com.example.Pr03VM;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EditDto {
    private int index; // 수정할 데이터의 인덱스(고정)
    private String name; // 상품명
    private int price; // 가격
    private LocalDate limit_date; // 유통기한
}