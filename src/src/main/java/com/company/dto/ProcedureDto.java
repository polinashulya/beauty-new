package com.company.dto;

import com.company.entity.CategoryEntity;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProcedureDto extends AbstractDto{
    private String name;
    private String duration;
    private BigDecimal price;
    private CategoryEntity category;
}
