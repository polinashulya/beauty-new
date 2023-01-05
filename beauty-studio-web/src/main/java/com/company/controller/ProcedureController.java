package com.company.controller;

import com.company.service.dto.ProcedureDto;
import com.company.service.ProcedureService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ProcedureController {
    private final ProcedureService procedureService;

    @PostMapping("/procedures")
    public ResponseEntity<ProcedureDto> save (@RequestBody ProcedureDto procedureDto){
        ProcedureDto saved = procedureService.saveProcedure(procedureDto);
        return ResponseEntity.ok(saved);
    }
}
