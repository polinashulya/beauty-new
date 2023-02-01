package com.company.entity.user;

import com.company.entity.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "employees")
//@PrimaryKeyJoinColumn(name = "employee_id")
@SuperBuilder(toBuilder = true)
@Setter
@Getter
@NoArgsConstructor
//@AllArgsConstructor
public class EmployeeEntity extends UserEntity {

    @Column(name = "experience")
    private String experience;

    @Embedded
    private Address address;

    @ManyToMany
    @JoinTable(name = "employees_positions",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "position_id")

    )
    private Set<EmployeePositionEntity> positions = new HashSet<>();

//    @ManyToOne
//    private EmployeePositionEntity position;
}
