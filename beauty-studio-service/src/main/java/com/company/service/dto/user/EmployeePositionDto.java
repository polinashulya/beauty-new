package com.company.service.dto.user;

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
public class EmployeePositionDto extends AbstractCoreDto {

    @NotBlank(message = "Name is mandatory")
    private String name;

}