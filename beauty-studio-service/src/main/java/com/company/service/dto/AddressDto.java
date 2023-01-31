package com.company.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class AddressDto extends AbstractDto{

    @NotBlank(message = "Zip code is mandatory")
    private Integer zipCode;

    @NotBlank(message = "City is mandatory")
    private String  city;

    @NotBlank(message = "House is mandatory")
    @Min(1)
    private Integer  house;

    @Min(1)
    private Integer apartment;

}
