package com.company.controller;

import com.company.service.dto.user.ClientDto;
import com.company.service.dto.user.UserDto;
import com.company.service.dto.user.UserSignUpDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1/users/clients") //general basic mapping
public interface ClientController {

    @PostMapping("/sign-up")
    ResponseEntity<ClientDto> register(@RequestBody @Valid UserSignUpDto userSignUpDto);

    @GetMapping("/{id}")
    ResponseEntity<ClientDto> findById(@PathVariable("id") Long clientId);

    @GetMapping
    ResponseEntity<List<ClientDto>> findAll();

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") Long clientId);

}