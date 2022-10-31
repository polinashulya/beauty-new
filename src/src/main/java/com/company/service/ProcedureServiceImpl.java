package com.company.service;

import com.company.dto.ProcedureDto;
import com.company.entity.ProcedureEntity;
import com.company.mapper.ProcedureMapper;
import com.company.repository.ProcedureRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProcedureServiceImpl implements ProcedureService {
    private final ProcedureRepository procedureRepository;

    @Override
    public ProcedureDto saveProcedure(ProcedureDto procedureDto) {
        ProcedureMapper procedureMapper = new ProcedureMapper();
        ProcedureEntity procedureEntity = procedureRepository.save(procedureMapper.convertToEntity(procedureDto));
        procedureDto.setId(procedureEntity.getId());
        return procedureDto;
    }
}
