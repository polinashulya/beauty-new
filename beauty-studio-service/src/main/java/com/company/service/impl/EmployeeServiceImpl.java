package com.company.service.impl;

import com.company.entity.user.EmployeeEntity;
import com.company.repository.EmployeeRepository;
import com.company.service.EmployeeService;
import com.company.service.dto.user.EmployeeDto;
import com.company.service.exception.HttpStatusCode;
import com.company.service.exception.ResourceNotFoundException;
import com.company.service.mapper.user.EmployeeMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeMapper employeeMapper;
    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        EmployeeEntity employeeEntity = employeeMapper.toEntity(employeeDto) ;

        EmployeeEntity saved = employeeRepository.save(employeeEntity);

        return employeeMapper.toDto(saved);
    }

    @Override
    public EmployeeDto findById(Long employeeId) {
        EmployeeEntity employeeEntity = getEmployeeEntity(employeeId);

        return employeeMapper.toDto(employeeEntity);
    }

    @Override
    public List<EmployeeDto> findAll() {
        List<EmployeeEntity> employees = employeeRepository.findAll();

        return employeeMapper.toDtoList(employees);
    }

    private EmployeeEntity getEmployeeEntity(Long employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException(HttpStatusCode.NOT_FOUND, "Employee with id = " + employeeId + " not found!"));
    }

}
