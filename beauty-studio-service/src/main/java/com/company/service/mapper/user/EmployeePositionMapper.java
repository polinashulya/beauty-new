package com.company.service.mapper.user;

import com.company.entity.user.EmployeePositionEntity;
import com.company.service.dto.user.EmployeePositionDto;
import com.company.service.mapper.core.AbstractMapper;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeePositionMapper extends AbstractMapper<EmployeePositionDto, EmployeePositionEntity> {
}
