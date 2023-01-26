package com.company.service;

import com.company.service.dto.UserDto;
import com.company.service.dto.UserSignUpDto;

import java.util.List;

public interface UserService {
    UserDto saveUser(UserDto userDto);

    UserDto signUpUser(UserSignUpDto userSignUpDto);

    UserDto findById(Long userId);

    List<UserDto> findAll();

    void delete(Long userId);

}