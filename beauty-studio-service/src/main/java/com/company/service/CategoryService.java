package com.company.service;

import com.company.service.dto.CategoryDto;
import com.company.service.dto.ProcedureDto;

import java.util.List;

public interface CategoryService {

    CategoryDto saveCategory(CategoryDto categoryDto);

    CategoryDto findById(Long categoryId);

    List<CategoryDto> findAll();

    void delete(Long categoryDto);

}
