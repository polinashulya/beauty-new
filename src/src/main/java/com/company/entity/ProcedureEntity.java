package com.company.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "procedures")
public class ProcedureEntity extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "duration")
    private String duration;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne
    private CategoryEntity category;
}
