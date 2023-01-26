package com.company.service.impl;

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

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class ProcedureServiceImpl implements ProcedureService {

    private final ProcedureMapper procedureMapper;
    private final ProcedureRepository procedureRepository;
    private final CategoryRepository categoryRepository;

    @Override
    @Transactional
    public ProcedureDto saveProcedure(ProcedureDto procedureDto) {

        if (procedureRepository.existsByName(procedureDto.getName())) {
            throw new ServiceException(HttpStatusCode.CONFLICT, "Procedure with this name = " + procedureDto.getName() + " already exist!");
        }

        if (!categoryRepository.existsById(procedureDto.getCategory().getId())) {
            throw new ServiceException(HttpStatusCode.NOT_FOUND, "Category = " + procedureDto.getCategory().getId() + " does not exists");
        }

        ProcedureEntity procedureEntity = procedureMapper.toEntity(procedureDto);
        procedureEntity.setCategory(
                categoryRepository.getOne(procedureDto.getCategory().getId())
        );

        ProcedureEntity saved = procedureRepository.save(procedureEntity);

        return procedureMapper.toDto(saved);
    }

    @Override
    public ProcedureDto findById(Long procedureId) {
        ProcedureEntity procedureEntity = getProcedureEntity(procedureId);
        return procedureMapper.toDto(procedureEntity);
    }

    @Override
    public List<ProcedureDto> findAll() {
        List<ProcedureEntity> procedures = procedureRepository.findAll();

        return procedureMapper.toDtoList(procedures);
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
