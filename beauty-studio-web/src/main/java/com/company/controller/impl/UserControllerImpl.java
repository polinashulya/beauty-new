package com.company.controller.impl;

import com.company.controller.UserController;
import com.company.service.UserService;
import com.company.service.dto.user.UserDto;
import com.company.service.dto.UserSignUpDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users") //general basic mapping
public class UserControllerImpl implements UserController {
    private final UserService userService;

    @Override
    public ResponseEntity<UserDto> save(@RequestBody @Valid UserDto userDto) {
        UserDto saved = userService.saveUser(userDto);
        return ResponseEntity.ok(saved);
    }

    @Override
    public ResponseEntity<UserDto> register(@RequestBody @Valid UserSignUpDto userSignUpDto) {
        UserDto saved = userService.signUpUser(userSignUpDto);
        return ResponseEntity.ok(saved);
    }

    @Override
    public ResponseEntity<UserDto> findById(@PathVariable("id") Long userId) {
        UserDto userDto = userService.findById(userId);

        return ResponseEntity.ok(userDto);
    }

    @Override
    public ResponseEntity<List<UserDto>> findAll() {
        List<UserDto> users = userService.findAll();

        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long userId) {
        userService.delete(userId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
