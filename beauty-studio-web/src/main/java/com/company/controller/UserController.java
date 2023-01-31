package com.company.controller;

import com.company.service.dto.user.UserDto;
import com.company.service.dto.UserSignUpDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1/users") //general basic mapping
public interface UserController {

    @PostMapping
    ResponseEntity<UserDto> save(@RequestBody @Valid UserDto userDto);

    @PostMapping("/sign-up")
    ResponseEntity<UserDto> register(@RequestBody @Valid UserSignUpDto userSignUpDto);

    @GetMapping("/{id}")
    ResponseEntity<UserDto> findById(@PathVariable("id") Long userId);

    @GetMapping
    ResponseEntity<List<UserDto>> findAll();

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") Long userId);

}
