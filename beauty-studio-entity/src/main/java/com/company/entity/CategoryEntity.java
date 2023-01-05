package com.company.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "categories")
public class CategoryEntity extends AbstractEntity {
    @Column(name = "name")
    private String name;
}
