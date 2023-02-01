package com.company.controller;

import com.company.service.dto.user.EmployeePositionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@RequestMapping("/api/v1/positions")
public interface EmployeePositionController {

    @PostMapping
    ResponseEntity<EmployeePositionDto> save(@RequestBody EmployeePositionDto employeePositionDto);

    @GetMapping("/{id}")
    ResponseEntity<EmployeePositionDto> findById(@PathVariable("id") @Min(0) Long employeePositionId);

    @GetMapping
    ResponseEntity<List<EmployeePositionDto>> findAll();

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") Long employeePositionId);

}