package com.company.service.dto;

import com.company.service.dto.core.AbstractCoreDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class ProcedureDto extends AbstractCoreDto {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Duration is mandatory")
    private String duration;

    @NotBlank(message = "Price is mandatory")
    @Min(0)
    private BigDecimal price;

    @NotNull(message = "Category is mandatory")
    private CategoryDto category;

}
