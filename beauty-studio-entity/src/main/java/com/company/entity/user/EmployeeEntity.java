package com.company.entity.user;

import com.company.entity.Address;
import com.company.entity.core.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;


@Entity
@Table(name = "employees")
//@PrimaryKeyJoinColumn(name = "employee_id")
@SuperBuilder(toBuilder = true)
@Setter
@Getter
@NoArgsConstructor
//@AllArgsConstructor
public class EmployeeEntity extends UserEntity {

   // private Set<EmployeePositionEntity> positions = new HashSet<>();

    @Column(name = "experience")
    private String experience;

    @Embedded
    private Address address;

}
