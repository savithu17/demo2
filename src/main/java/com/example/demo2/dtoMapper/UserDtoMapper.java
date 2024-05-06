package com.example.demo2.dtoMapper;

import com.example.demo2.dto.UserRequestDto;
import com.example.demo2.dto.UserResponseDto;
import com.example.demo2.entity.Company;
import com.example.demo2.entity.User;

public class UserDtoMapper {
    public static User mapToUser(UserRequestDto userRequestDto, Company company){
        User user=new User();
        user.setFirstName(userRequestDto.getFristName());
        user.setLastName(userRequestDto.getLastName());
        user.setAge(userRequestDto.getAge());
        user.setCompany(company);
        return user;
    }

    public static UserResponseDto mapToDto(User user){
        UserResponseDto userResponseDto=new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setFristName(user.getFirstName());
        userResponseDto.setFristName(user.getLastName());
        userResponseDto.setAge(user.getAge());
        userResponseDto.setCompanyId(user.getCompany().getId());
        return userResponseDto;
    }








}
