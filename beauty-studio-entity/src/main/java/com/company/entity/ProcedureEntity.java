package com.company.entity;

import com.company.entity.core.AbstractCoreEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "procedures")
@SuperBuilder(toBuilder = true)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProcedureEntity extends AbstractCoreEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "duration")
    private String duration;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne
    private CategoryEntity category;
}
