package com.company.service.mapper;

import com.company.entity.UserRoleEntity;
import com.company.service.dto.UserRoleDto;
import org.springframework.stereotype.Component;

@Component
public class UserRoleMapper {

    public UserRoleDto toDto(UserRoleEntity roleEntity) {
        return UserRoleDto.builder()
                .id(roleEntity.getId())
                .name(roleEntity.getName())
                .build();
    }
}
