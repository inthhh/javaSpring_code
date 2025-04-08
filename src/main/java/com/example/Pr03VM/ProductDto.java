package com.example.Pr03VM;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String name; // 상품명
    private int price; // 가격
    private LocalDate limit_date; // 유통기한
}