package com.company.service;

import com.company.service.dto.user.EmployeePositionDto;

import java.util.List;

public interface EmployeePositionService {

    EmployeePositionDto saveEmployeePosition(EmployeePositionDto employeePositionDto);

    EmployeePositionDto findById(Long employeePositionId);

    List<EmployeePositionDto> findAll();

    void delete(Long employeePositionId);

}
