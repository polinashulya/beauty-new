package com.company.service.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
public class UserRoleDto extends AbstractDto {
    private String name;
}
