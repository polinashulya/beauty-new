package com.company.controller;

import com.company.service.UserService;
import com.company.service.dto.UserDto;
import com.company.service.dto.UserSignUpDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users") //general basic mapping
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {
        UserDto saved = userService.saveUser(userDto);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<UserDto> register(@RequestBody UserSignUpDto userSignUpDto) {
        UserDto saved = userService.registrationUser(userSignUpDto);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable("id") Long userId) {
        UserDto userDto = userService.findById(userId);

        return ResponseEntity.ok(userDto);
    }
}
