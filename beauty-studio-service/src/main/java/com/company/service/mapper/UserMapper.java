package com.company.service.mapper;

import com.company.entity.UserEntity;
import com.company.service.dto.UserDto;
import com.company.service.dto.UserSignUpDto;
import com.company.service.mapper.core.AbstractMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {UserRoleMapper.class})
public interface UserMapper extends AbstractMapper<UserDto, UserEntity> {

    UserEntity toEntityFromSignUp(UserSignUpDto userSignUpDto);

}
