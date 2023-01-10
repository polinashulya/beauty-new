package com.company.service.mapper;

import com.company.service.dto.CategoryDto;
import com.company.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
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
