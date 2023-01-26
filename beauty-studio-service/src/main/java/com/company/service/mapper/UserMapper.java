package com.company.service.mapper;

import com.company.entity.UserEntity;
import com.company.entity.UserRoleEntity;
import com.company.service.dto.UserDto;
import com.company.service.dto.UserSignUpDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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
                .role(roleMapper.convertToDto(userEntity.getUserRole()))
                .build();
    }

    public UserEntity convertToEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDto.getName());
        return userEntity;
    }

    public UserEntity convertToEntityFromSingUp(UserSignUpDto userSignUpDto, UserRoleEntity userRole) {
        return UserEntity.builder()
                .email(userSignUpDto.getEmail())
                .password(userSignUpDto.getPassword())
                .name(userSignUpDto.getName())
                .userRole(userRole)
                .build();
    }

    public List<UserDto> convertListToDto(List<UserEntity> userEntities) {
        return userEntities.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
