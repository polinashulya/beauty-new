package com.company.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class CategoryDto extends AbstractDto {

    @NotBlank(message = "Name is mandatory")
    private String name;

}
