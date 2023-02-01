package com.company.service.dto.user;

import com.company.service.dto.UserRoleDto;
import com.company.service.dto.core.AbstractCoreDto;
import com.company.service.dto.validation.ValidPhone;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public abstract class UserDto extends AbstractCoreDto {

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

    @ValidPhone(message = "Phone number must be valid")
    private String phoneNumber;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate dateOfBirth;

}
