package com.company.service.dto.user;

import com.company.service.dto.AddressDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class EmployeeDto extends UserDto {

    private String experience;

    private AddressDto address;

    private Set<EmployeePositionDto> positions = new HashSet<>();

}
