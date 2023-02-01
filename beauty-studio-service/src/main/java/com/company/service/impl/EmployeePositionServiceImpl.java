package com.company.service.impl;

import com.company.entity.CategoryEntity;
import com.company.entity.user.EmployeeEntity;
import com.company.entity.user.EmployeePositionEntity;
import com.company.repository.CategoryRepository;
import com.company.repository.EmployeePositionRepository;
import com.company.repository.EmployeeRepository;
import com.company.repository.ProcedureRepository;
import com.company.service.EmployeePositionService;
import com.company.service.dto.CategoryDto;
import com.company.service.dto.user.EmployeePositionDto;
import com.company.service.exception.HttpStatusCode;
import com.company.service.exception.ResourceNotFoundException;
import com.company.service.exception.ServiceException;
import com.company.service.mapper.CategoryMapper;
import com.company.service.mapper.user.EmployeePositionMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeePositionServiceImpl implements EmployeePositionService {

    private final EmployeePositionMapper employeePositionMapper;
    private final EmployeePositionRepository employeePositionRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public EmployeePositionDto saveEmployeePosition(EmployeePositionDto employeePositionDto) {

        if (employeePositionRepository.existsByName(employeePositionDto.getName())) {
            throw new ServiceException(HttpStatusCode.CONFLICT, "Position with this name = " + employeePositionDto.getName() + " already exist!");
        }

        EmployeePositionEntity employeePositionEntity = employeePositionMapper.toEntity(employeePositionDto);

        EmployeePositionEntity saved = employeePositionRepository.save(employeePositionEntity);

        return employeePositionMapper.toDto(saved);
    }

    @Override
    public EmployeePositionDto findById(Long employeePositionId) {
        EmployeePositionEntity categoryEntity = getEmployeePositionEntity(employeePositionId);

        return employeePositionMapper.toDto(categoryEntity);
    }

    private EmployeePositionEntity getEmployeePositionEntity(Long employeePositionId) {
        return employeePositionRepository.findById(employeePositionId)
                .orElseThrow(() -> new ResourceNotFoundException(HttpStatusCode.NOT_FOUND, "Position with id = " + employeePositionId + " not found!"));
    }

    @Override
    public List<EmployeePositionDto> findAll() {
        List<EmployeePositionEntity> categories = employeePositionRepository.findAll();

        return employeePositionMapper.toDtoList(categories);
    }

    @Override
    public void delete(Long employeePositionId) {

        EmployeePositionEntity employeePositionEntity = getEmployeePositionEntity(employeePositionId);

//        if (employeeRepository.existsEmployeeEntitiesByPositionsById(employeePositionEntity.getId())) {
//            throw new ServiceException(HttpStatusCode.CONFLICT, "Position contains employees, delete them firstly");
//        }

        employeePositionRepository.delete(employeePositionEntity);
    }
}
