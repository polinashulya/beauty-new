package com.company.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user_roles")
public class UserRoleEntity extends AbstractEntity {

    @Column(name = "name", unique = true, nullable = false)
    private String name;

}
