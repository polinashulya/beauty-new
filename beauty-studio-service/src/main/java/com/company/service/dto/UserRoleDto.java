package com.company.service.dto;

import com.company.service.dto.core.AbstractCoreDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class UserRoleDto extends AbstractCoreDto {

    @NotBlank(message = "Name is mandatory")
    private String name;

}
