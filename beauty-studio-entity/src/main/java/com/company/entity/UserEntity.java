package com.company.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class UserEntity extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

}
