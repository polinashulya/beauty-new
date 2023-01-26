package com.company.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class UserSignUpDto implements Serializable {

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email must be valid")
    private String email;

    @NotBlank(message = "Password is mandatory")
    private String password;

    @NotBlank(message = "Confirmed password is mandatory")
    private String confirmedPassword;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Role is mandatory")
    private UserRoleDto role;

}
