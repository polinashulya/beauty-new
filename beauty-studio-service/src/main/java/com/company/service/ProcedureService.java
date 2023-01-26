package com.company.service;

import com.company.service.dto.ProcedureDto;

import java.util.List;

public interface ProcedureService {

    ProcedureDto saveProcedure(ProcedureDto procedureDto);

    ProcedureDto findById(Long procedureId);

    List<ProcedureDto> findAll();

    void delete(Long procedureId);

}
