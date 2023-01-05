package com.company.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Embeddable
public abstract class AbstractEntity {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
