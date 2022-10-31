package com.company.mapper;

import com.company.dto.CategoryDto;
import com.company.dto.ProcedureDto;
import com.company.entity.CategoryEntity;
import com.company.entity.ProcedureEntity;

public class CategoryMapper {
    public CategoryDto convertToDto(CategoryEntity categoryEntity) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(categoryEntity.getId());
        categoryDto.setName(categoryEntity.getName());
        return categoryDto;
    }

    public CategoryEntity convertToEntity(CategoryDto categoryDto) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(categoryEntity.getId());
        categoryEntity.setName(categoryDto.getName());
        return categoryEntity;
    }
}
