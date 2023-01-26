package com.company.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
@SuperBuilder(toBuilder = true)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEntity extends AbstractEntity {

    @Column(name = "name", unique = true, nullable = false)
    private String name;

}
