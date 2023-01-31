package com.company.service;

import com.company.service.dto.user.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto saveEmployee (EmployeeDto employeeDto);

    EmployeeDto findById(Long employeeDto);

    List<EmployeeDto> findAll();

}
