package com.company.service.mapper;

import com.company.entity.UserRoleEntity;
import com.company.service.dto.UserRoleDto;
import com.company.service.mapper.core.AbstractMapper;
import org.mapstruct.Mapper;

@Mapper
public interface UserRoleMapper extends AbstractMapper<UserRoleDto, UserRoleEntity> {

}
