package com.company.entity.user;

import com.company.entity.core.AbstractEntity;
import com.company.entity.ProcedureEntity;

import java.util.HashSet;
import java.util.Set;

public class EmployeePositionEntity extends AbstractEntity {

    private String name;

    private Set<ProcedureEntity> procedures = new HashSet<>();

}
