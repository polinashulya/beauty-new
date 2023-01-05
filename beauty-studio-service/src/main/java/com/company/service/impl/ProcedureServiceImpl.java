package com.company.service.impl;

import com.company.service.ProcedureService;
import com.company.service.dto.ProcedureDto;
import com.company.entity.ProcedureEntity;
import com.company.service.mapper.ProcedureMapper;
import com.company.repository.ProcedureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProcedureServiceImpl implements ProcedureService {
    private final ProcedureMapper procedureMapper;
    private final ProcedureRepository procedureRepository;

    @Override
    public ProcedureDto saveProcedure(ProcedureDto procedureDto) {
        ProcedureEntity procedureEntity = procedureMapper.convertToEntity(procedureDto);
        ProcedureEntity saved = procedureRepository.save(procedureEntity);
        return procedureMapper.convertToDto(saved);
    }

    @Override
    public ProcedureDto deleteProcedure(ProcedureDto procedureDto) {
        return null;
    }
}
