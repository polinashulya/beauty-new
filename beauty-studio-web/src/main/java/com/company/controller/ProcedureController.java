package com.company.controller;

import com.company.service.dto.ProcedureDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/procedures")
public interface ProcedureController {

    @PostMapping
    ResponseEntity<ProcedureDto> save(@RequestBody ProcedureDto procedureDto);

    @GetMapping("/{id}")
    ResponseEntity<ProcedureDto> findById(@PathVariable("id") Long procedureId);

    @GetMapping
    ResponseEntity<List<ProcedureDto>> findAll();

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") Long procedureId);

}
