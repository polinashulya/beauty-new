package com.company.entity.user;

import com.company.entity.core.AbstractCoreEntity;
import com.company.entity.ProcedureEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "positions")
@SuperBuilder(toBuilder = true)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePositionEntity extends AbstractCoreEntity {

    @Column(name = "name", unique = true, nullable = false)
    private String name;

}
