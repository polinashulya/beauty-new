package com.company.entity;

import com.company.entity.core.AbstractCoreEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "user_roles")
@SuperBuilder(toBuilder = true)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleEntity extends AbstractCoreEntity {

    @Column(name = "name", unique = true, nullable = false)
    private String name;

}
