package com.company.service.mapper;

import com.company.entity.CategoryEntity;
import com.company.entity.ProcedureEntity;
import com.company.service.dto.CategoryDto;
import com.company.service.dto.ProcedureDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ProcedureMapper {

    private final CategoryMapper categoryMapper;

    public ProcedureDto convertToDto(ProcedureEntity procedureEntity) {
        return ProcedureDto.builder()
                .id(procedureEntity.getId())
                .name(procedureEntity.getName())
                .duration(procedureEntity.getDuration())
                .price(procedureEntity.getPrice())
                .category(categoryMapper.convertToDto(procedureEntity.getCategory()))
                .build();
    }

    public ProcedureEntity convertToEntity(ProcedureDto procedureDto, CategoryEntity categoryEntity) {
        return ProcedureEntity.builder()
                .name(procedureDto.getName())
                .duration(procedureDto.getDuration())
                .price(procedureDto.getPrice())
                .category(categoryEntity)
                .build();
    }

    public ProcedureEntity convertToEntity(ProcedureDto procedureDto, CategoryDto categoryDto) {
        return ProcedureEntity.builder()
                .name(procedureDto.getName())
                .duration(procedureDto.getDuration())
                .price(procedureDto.getPrice())
                .category(categoryMapper.convertToEntity(categoryDto))
                .build();
    }

    public List<ProcedureDto> convertListToDto(List<ProcedureEntity> procedureEntities) {
        return procedureEntities.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
