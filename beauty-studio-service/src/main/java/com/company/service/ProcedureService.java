package com.company.service;

import com.company.service.dto.ProcedureDto;

public interface ProcedureService {
    ProcedureDto saveProcedure(ProcedureDto procedureDto);
    ProcedureDto deleteProcedure(ProcedureDto procedureDto);

}
