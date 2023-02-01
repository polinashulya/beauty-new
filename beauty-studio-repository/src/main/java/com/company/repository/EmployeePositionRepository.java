package com.company.repository;

import com.company.entity.user.EmployeePositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeePositionRepository extends JpaRepository<EmployeePositionEntity, Long> {

    Boolean existsByName(String name);

    EmployeePositionEntity getByName(String name);

    Optional<EmployeePositionEntity> findByName(String name);

}
