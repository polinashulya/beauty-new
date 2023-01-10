package com.company.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "users")
@SuperBuilder(toBuilder = true)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends AbstractEntity {

    @Column(name = "email", unique = true)//unique means that it would be unique accross your table
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @ManyToOne
    private UserRoleEntity userRole;
}
