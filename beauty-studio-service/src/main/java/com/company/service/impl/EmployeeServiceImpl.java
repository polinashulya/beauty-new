package com.company.service.impl;

import com.company.entity.user.EmployeeEntity;
import com.company.repository.EmployeePositionRepository;
import com.company.repository.EmployeeRepository;
import com.company.service.EmployeePositionService;
import com.company.service.EmployeeService;
import com.company.service.dto.user.EmployeeDto;
import com.company.service.exception.HttpStatusCode;
import com.company.service.exception.ResourceNotFoundException;
import com.company.service.exception.ServiceException;
import com.company.service.mapper.user.EmployeeMapper;
import com.company.service.mapper.user.EmployeePositionMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeMapper employeeMapper;
    private final EmployeeRepository employeeRepository;
    private final EmployeePositionRepository employeePositionRepository;
    private final EmployeePositionService employeePositionService;

    private final EmployeePositionMapper positionMapper;

    @Override
    @Transactional
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        if (employeeRepository.existsByEmail(employeeDto.getEmail())) {
            throw new ServiceException(HttpStatusCode.CONFLICT, "Employee with email = " + employeeDto.getEmail() + " already exist!");
        }
//
//        employeeDto.getPositions()
//                .forEach(employeePositionDto -> {
//                            if (!employeePositionRepository.existsByName(employeePositionDto.getName())) {
//                               // employeePositionService.saveEmployeePosition(employeePositionDto);
//                                employeePositionRepository.save(positionMapper.toEntity(employeePositionDto));
//                            }
//                        }
//                );

        EmployeeEntity employeeEntity = employeeMapper.toEntity(employeeDto);

        employeeEntity.setPositions(

                employeeEntity.getPositions()
                        .stream()
                        .map(it -> {
                            if (Objects.nonNull(it.getId())) {
                                return employeePositionRepository.findById(it.getId())
                                        .orElseThrow(() -> new ResourceNotFoundException(HttpStatusCode.BAD_REQUEST, "Position does not exists!"));
                            } else {
                                if (!employeePositionRepository.existsByName(it.getName())) {
                                    return employeePositionRepository.save(it);
                                } else {
                                    return employeePositionRepository.getByName(it.getName());
                                }
//                                return employeePositionRepository.findByName(it.getName())
//                                        .orElse(employeePositionRepository.save(it));
                            }
                        })
                        .collect(Collectors.toSet())

        );

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

    @Override
    public void delete(Long employeeId) {
        EmployeeEntity employeeEntity = getEmployeeEntity(employeeId);

        employeeRepository.delete(employeeEntity);
    }

    private EmployeeEntity getEmployeeEntity(Long employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException(HttpStatusCode.NOT_FOUND, "Employee with id = " + employeeId + " not found!"));
    }

}
