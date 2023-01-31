package com.company.controller.impl;

import com.company.controller.CategoryController;
import com.company.service.CategoryService;
import com.company.service.dto.CategoryDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.net.URI;
import java.util.List;


@RestController
@AllArgsConstructor
public class CategoryControllerImpl implements CategoryController {

    private final CategoryService categoryService;

    @Override
    public ResponseEntity<CategoryDto> save(@RequestBody CategoryDto categoryDto) {
        CategoryDto saved = categoryService.saveCategory(categoryDto);
        return ResponseEntity.created(
                        URI.create("/api/v1/catergories/" + saved.getId())
                )
                .body(saved);
    }

    @Override
    public ResponseEntity<CategoryDto> findById(@PathVariable("id") @Min(0) Long categoryId) {
        CategoryDto categoryDto = categoryService.findById(categoryId);

        return ResponseEntity.ok(categoryDto);
    }

    @Override
    public ResponseEntity<List<CategoryDto>> findAll() {
        List<CategoryDto> categories = categoryService.findAll();

        return ResponseEntity.ok(categories);
    }

    @Override
    public ResponseEntity<Void> delete(@PathVariable("id") Long categoryId) {
        categoryService.delete(categoryId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
