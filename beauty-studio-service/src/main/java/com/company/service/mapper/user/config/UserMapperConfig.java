package com.company.service.mapper.user.config;

import com.company.entity.user.UserEntity;
import com.company.service.dto.user.UserDto;
import com.company.service.mapper.core.AbstractMapper;
import org.mapstruct.MapperConfig;

@MapperConfig//(uses = UserRoleMapper.class)
public interface UserMapperConfig extends AbstractMapper<UserDto, UserEntity> {

    // UserDto mapUser(UserEntity entity);

}
