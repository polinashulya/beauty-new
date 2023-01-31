package com.company.entity.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
@SuperBuilder(toBuilder = true)
@Setter
@Getter
@NoArgsConstructor
//@AllArgsConstructor
public class ClientEntity extends UserEntity {


    private String test;

}
