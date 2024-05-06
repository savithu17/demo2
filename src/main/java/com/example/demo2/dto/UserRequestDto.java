package com.example.demo2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class UserRequestDto {
    private String fristName;
    private String lastName;
    private int age;
    private Long companyId;
}
