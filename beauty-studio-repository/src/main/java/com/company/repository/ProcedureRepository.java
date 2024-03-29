package com.company.repository;

import com.company.entity.ProcedureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProcedureRepository extends JpaRepository<ProcedureEntity, Long> {

    Optional<ProcedureEntity> findByName(String name);

    Boolean existsByName(String name);

    Boolean existsProcedureEntityByCategoryId(Long categoryId);

}
