package com.company.controller;

import com.company.service.dto.CategoryDto;
import com.company.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/categories")
    public ResponseEntity<CategoryDto> save (@RequestBody CategoryDto categoryDto){
        CategoryDto saved = categoryService.saveCategory(categoryDto);
        return ResponseEntity.ok(saved);
    }
}
