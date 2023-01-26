package com.company.service.mapper;

import com.company.entity.CategoryEntity;
import com.company.service.dto.CategoryDto;
import com.company.service.mapper.core.AbstractMapper;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper extends AbstractMapper<CategoryDto, CategoryEntity> {

}
