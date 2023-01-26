package com.company.service.impl;

import com.company.entity.CategoryEntity;
import com.company.entity.ProcedureEntity;
import com.company.repository.CategoryRepository;
import com.company.repository.ProcedureRepository;
import com.company.service.ProcedureService;
import com.company.service.dto.ProcedureDto;
import com.company.service.exception.HttpStatusCode;
import com.company.service.exception.ResourceNotFoundException;
import com.company.service.exception.ServiceException;
import com.company.service.mapper.ProcedureMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProcedureServiceImpl implements ProcedureService {

    private final ProcedureMapper procedureMapper;
    private final ProcedureRepository procedureRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public ProcedureDto saveProcedure(ProcedureDto procedureDto) {

       if(procedureRepository.existsByName(procedureDto.getName())) {
           throw new ServiceException(HttpStatusCode.CONFLICT,"Procedure with this name = " + procedureDto.getName() + " already exist!");
       };

        CategoryEntity categoryEntity = categoryRepository.findById(procedureDto.getCategory().getId())
                .orElseThrow(() -> new ServiceException(HttpStatusCode.NOT_FOUND,"Provided Category does not exist"));

        ProcedureEntity procedureEntity = procedureMapper.convertToEntity(procedureDto, categoryEntity);

        ProcedureEntity saved = procedureRepository.save(procedureEntity);

        return procedureMapper.convertToDto(saved);
    }

    @Override
    public ProcedureDto findById(Long procedureId) {
        ProcedureEntity procedureEntity = getProcedureEntity(procedureId);
        return procedureMapper.convertToDto(procedureEntity);
    }

    @Override
    public List<ProcedureDto> findAll() {
        List<ProcedureEntity> procedures = procedureRepository.findAll();

        return procedureMapper.convertListToDto(procedures);
    }

    @Override
    public void delete(Long procedureId) {
        ProcedureEntity procedureEntity = getProcedureEntity(procedureId);

        procedureRepository.delete(procedureEntity);
    }

    private ProcedureEntity getProcedureEntity(Long procedureId) {
        return procedureRepository.findById(procedureId)
                .orElseThrow(() -> new ResourceNotFoundException(HttpStatusCode.NOT_FOUND, "Procedure with id = " + procedureId + " not found!"));
    }
}
