package com.company.controller.impl;

import com.company.controller.EmployeeController;
import com.company.service.EmployeeService;
import com.company.service.dto.user.EmployeeDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class EmployeeControllerImpl implements EmployeeController {

    private final EmployeeService employeeService;

    @Override
    public ResponseEntity<EmployeeDto> save(EmployeeDto employeeDto) {
        EmployeeDto saved = employeeService.saveEmployee(employeeDto);

        return ResponseEntity.ok(saved);
    }

    @Override
    public ResponseEntity<EmployeeDto> findById(Long employeeId) {
        EmployeeDto employeeDto = employeeService.findById(employeeId);

        return ResponseEntity.ok(employeeDto);
    }

    @Override
    public ResponseEntity<List<EmployeeDto>> findAll() {
        List<EmployeeDto> employees = employeeService.findAll();

        return ResponseEntity.ok(employees);
    }
}
