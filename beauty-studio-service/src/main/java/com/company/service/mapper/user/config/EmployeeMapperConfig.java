package com.company.service.mapper.user.config;

import com.company.entity.user.EmployeeEntity;
import com.company.service.dto.user.EmployeeDto;
import com.company.service.mapper.core.AbstractMapper;
import org.mapstruct.MapperConfig;

@MapperConfig(uses = UserMapperConfig.class)
public interface EmployeeMapperConfig extends AbstractMapper<EmployeeDto, EmployeeEntity> { //extends UserMapperConfig {

}
