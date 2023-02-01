package com.company.service.dto;

import com.company.service.dto.core.AbstractCoreDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class AddressDto extends AbstractCoreDto {

    @NotBlank(message = "Zip code is mandatory")
    private Integer zipCode;

    @NotBlank(message = "City is mandatory")
    private String city;

    @NotBlank(message = "Street is mandatory")
    private String street;

    @NotBlank(message = "House is mandatory")
    @Min(1)
    private Integer house;

    @Min(1)
    private Integer apartment;

}
