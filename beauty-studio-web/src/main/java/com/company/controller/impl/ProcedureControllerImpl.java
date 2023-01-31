package com.company.controller.impl;

import com.company.controller.ProcedureController;
import com.company.service.ProcedureService;
import com.company.service.dto.ProcedureDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/procedures")
public class ProcedureControllerImpl implements ProcedureController {

    private final ProcedureService procedureService;

    @Override
    public ResponseEntity<ProcedureDto> save(@RequestBody ProcedureDto procedureDto) {
        ProcedureDto saved = procedureService.saveProcedure(procedureDto);

        return ResponseEntity.ok(saved);
    }

    @Override
    public ResponseEntity<ProcedureDto> findById(@PathVariable("id") Long procedureId) {
        ProcedureDto procedureDto = procedureService.findById(procedureId);

        return ResponseEntity.ok(procedureDto);
    }

    @Override
    public ResponseEntity<List<ProcedureDto>> findAll(){
        List<ProcedureDto> procedures = procedureService.findAll();

        return ResponseEntity.ok(procedures);
    }

    @Override
    public ResponseEntity<Void> delete(@PathVariable("id") Long procedureId) {
        procedureService.delete(procedureId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
