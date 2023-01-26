package com.company.controller;

import com.company.service.dto.CategoryDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;


@RequestMapping("/api/v1/categories")
public interface CategoryController {

    @PostMapping
    ResponseEntity<CategoryDto> save(@RequestBody CategoryDto categoryDto);

    @GetMapping("/{id}")
    ResponseEntity<CategoryDto> findById(@PathVariable("id") @Min(0) Long categoryId);

    @GetMapping
    ResponseEntity<List<CategoryDto>> findAll();

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") Long categoryId);

}
