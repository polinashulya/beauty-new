package com.company.entity.user;

import com.company.entity.UserRoleEntity;
import com.company.entity.core.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
@SuperBuilder(toBuilder = true)
@Setter
@Getter
@NoArgsConstructor
//@AllArgsConstructor
public abstract class UserEntity extends AbstractEntity {

    @Column(name = "email", unique = true)//unique means that it would be unique accross your table
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToOne
    private UserRoleEntity role;

    @Column(name = "firstname")
    private String firstname; //firstName

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "dateOfBirth")
    private LocalDate dateOfBirth;

}
