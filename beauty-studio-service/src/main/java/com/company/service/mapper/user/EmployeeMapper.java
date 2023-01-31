package com.company.service.mapper.user;

import com.company.entity.user.EmployeeEntity;
import com.company.service.dto.user.EmployeeDto;
import com.company.service.mapper.core.AbstractMapper;
import com.company.service.mapper.user.config.EmployeeMapperConfig;
import org.mapstruct.Mapper;

@Mapper(config = EmployeeMapperConfig.class)
public interface EmployeeMapper extends AbstractMapper<EmployeeDto, EmployeeEntity> {

}
