package com.company.service.impl;

import com.company.entity.CategoryEntity;
import com.company.repository.CategoryRepository;
import com.company.repository.ProcedureRepository;
import com.company.service.CategoryService;
import com.company.service.dto.CategoryDto;
import com.company.service.exception.HttpStatusCode;
import com.company.service.exception.ResourceNotFoundException;
import com.company.service.exception.ServiceException;
import com.company.service.mapper.CategoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;
    private final ProcedureRepository procedureRepository;

    @Override
    @Transactional
    public CategoryDto saveCategory(CategoryDto categoryDto) {

        if (categoryRepository.existsByName(categoryDto.getName())) {
            throw new ServiceException(HttpStatusCode.CONFLICT, "Category with this name = " + categoryDto.getName() + " already exist!");
        }

        CategoryEntity categoryEntity = categoryMapper.toEntity(categoryDto);

        CategoryEntity saved = categoryRepository.save(categoryEntity);

        return categoryMapper.toDto(saved);
    }

    @Override
    public CategoryDto findById(Long categoryId) {
        CategoryEntity categoryEntity = getCategoryEntity(categoryId);

        return categoryMapper.toDto(categoryEntity);
    }

    private CategoryEntity getCategoryEntity(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException(HttpStatusCode.NOT_FOUND, "Category with id = " + categoryId + " not found!"));
    }

    @Override
    public List<CategoryDto> findAll() {
        List<CategoryEntity> categories = categoryRepository.findAll();

        return categoryMapper.toDtoList(categories);
    }

    @Override
    public void delete(Long categoryId) {

        CategoryEntity categoryEntity = getCategoryEntity(categoryId);

        if (procedureRepository.existsProcedureEntityByCategoryId(categoryEntity.getId())) {
            throw new ServiceException(HttpStatusCode.CONFLICT, "Category contains procedures, delete them firstly");
        }

        categoryRepository.delete(categoryEntity);
    }

}
