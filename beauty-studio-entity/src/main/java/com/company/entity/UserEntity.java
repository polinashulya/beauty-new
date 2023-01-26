package com.company.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "users")
@SuperBuilder(toBuilder = true)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends AbstractEntity {

    @Column(name = "email", unique = true)//unique means that it would be unique accross your table
    @NotBlank(message = "Email is mandatory")
    @Email
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Column(name = "password")
    private String password;

    @ManyToOne
    private UserRoleEntity role;


    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;

}
