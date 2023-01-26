package com.company.service.mapper;

import com.company.entity.CategoryEntity;
import com.company.service.dto.CategoryDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryMapper {

    public CategoryDto convertToDto(CategoryEntity categoryEntity) {
        return CategoryDto.builder()
                .id(categoryEntity.getId())
                .name(categoryEntity.getName())
                .build();
    }

    public List<CategoryDto> convertListToDto(List<CategoryEntity> categoryEntities) {
        return categoryEntities.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public CategoryEntity convertToEntity(CategoryDto categoryDto) {
        return CategoryEntity.builder()
                .name(categoryDto.getName())
                .build();
    }
}
