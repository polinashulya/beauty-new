package com.company.service.dto.user;

import com.company.service.dto.AbstractDto;
import com.company.service.dto.UserRoleDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public abstract class UserDto extends AbstractDto {

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email must be valid")
    private String email;

    @NotNull(message = "Role is mandatory")
    private UserRoleDto role;

    @NotBlank(message = "Password is mandatory")
    private String password;

    @NotBlank(message = "Firstname is mandatory")
    private String firstname;

    @NotBlank(message = "Lastname is mandatory")
    private String lastName;

    @NotBlank(message = "Phone number is mandatory")
    private String phoneNumber;

    private LocalDate dateOfBirth;

}
