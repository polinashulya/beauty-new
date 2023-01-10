package com.company.service.mapper;

import com.company.entity.UserEntity;
import com.company.entity.UserRoleEntity;
import com.company.service.dto.UserDto;
import com.company.service.dto.UserSignUpDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserMapper {

    private final UserRoleMapper roleMapper;

    public UserDto convertToDto(UserEntity userEntity) {
        return UserDto.builder()
                .id(userEntity.getId())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .name(userEntity.getName())
                .role(roleMapper.toDto(userEntity.getUserRole()))
                .build();
    }

    public UserEntity convertToEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDto.getName());
        return userEntity;
    }

    public UserEntity toEntityFromSingUp(UserSignUpDto userSignUpDto, UserRoleEntity userRole) {
        return UserEntity.builder()
                .email(userSignUpDto.getEmail())
                .password(userSignUpDto.getPassword())
                .name(userSignUpDto.getName())
                .userRole(userRole)
                .build();
    }
}
