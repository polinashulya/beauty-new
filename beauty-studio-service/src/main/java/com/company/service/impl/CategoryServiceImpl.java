package com.company.service.impl;

import com.company.service.CategoryService;
import com.company.service.dto.CategoryDto;
import com.company.entity.CategoryEntity;
import com.company.service.mapper.CategoryMapper;
import com.company.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDto saveCategory(CategoryDto categoryDto) {
        CategoryEntity categoryEntity = categoryMapper.convertToEntity(categoryDto);
        CategoryEntity saved = categoryRepository.save(categoryEntity);
        return categoryMapper.convertToDto(saved);
    }
}
