package com.company.controller;

import com.company.service.dto.user.EmployeeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/users/employees")
public interface EmployeeController {

    @PostMapping
    ResponseEntity<EmployeeDto> save(@RequestBody EmployeeDto employeeDto);

    @GetMapping("/{id}")
    ResponseEntity<EmployeeDto> findById(@PathVariable("id") Long employeeId);

    @GetMapping
    ResponseEntity<List<EmployeeDto>> findAll();

}
