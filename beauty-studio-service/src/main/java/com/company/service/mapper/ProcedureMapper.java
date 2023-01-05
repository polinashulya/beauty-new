package com.company.service.mapper;

import com.company.service.dto.ProcedureDto;
import com.company.entity.ProcedureEntity;

public class ProcedureMapper {
    public ProcedureDto convertToDto(ProcedureEntity procedureEntity) {
        ProcedureDto procedureDto = new ProcedureDto();
        procedureDto.setId(procedureEntity.getId());
        procedureDto.setName(procedureEntity.getName());
        procedureDto.setDuration(procedureEntity.getDuration());
        procedureDto.setPrice(procedureEntity.getPrice());
        procedureDto.setCategory(procedureEntity.getCategory());
        return procedureDto;
    }

    public ProcedureEntity convertToEntity(ProcedureDto procedureDto) {
        ProcedureEntity procedureEntity = new ProcedureEntity();
        procedureEntity.setName(procedureDto.getName());
        procedureEntity.setDuration(procedureDto.getDuration());
        procedureEntity.setPrice(procedureDto.getPrice());
        procedureEntity.setCategory(procedureDto.getCategory());
        return procedureEntity;
    }
}
