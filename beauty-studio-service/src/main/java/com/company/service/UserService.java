package com.company.service;

import com.company.service.dto.UserSignUpDto;
import com.company.service.dto.UserDto;

public interface UserService {
    UserDto saveUser(UserDto userDto);

    UserDto registrationUser(UserSignUpDto userSignUpDto);

    UserDto findById(Long userId);
}