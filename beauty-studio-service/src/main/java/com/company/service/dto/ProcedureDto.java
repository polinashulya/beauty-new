package com.company.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class ProcedureDto extends AbstractDto {

    private String name;
    private String duration;
    private BigDecimal price;
    private CategoryDto category;

}
