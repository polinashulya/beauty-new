package com.company.service.dto;

import lombok.Data;

@Data
public class UserSignUpDto extends AbstractDto {

    private String email;
    private String password;
    private String confirmedPassword;
    private String name;

    private String roleName;

}
