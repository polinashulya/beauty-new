package com.company.controller.impl;

import com.company.controller.EmployeePositionController;
import com.company.service.EmployeePositionService;
import com.company.service.dto.ProcedureDto;
import com.company.service.dto.user.EmployeePositionDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;


@RestController
@AllArgsConstructor
public class EmployeePositionControllerImpl implements EmployeePositionController {

    private final EmployeePositionService employeePositionService;

    @Override
    public ResponseEntity<EmployeePositionDto> save(@RequestBody EmployeePositionDto employeePositionDto) {
        EmployeePositionDto saved = employeePositionService.saveEmployeePosition(employeePositionDto);

        return ResponseEntity.created(
                        URI.create("/api/v1/positions/" + saved.getId())
                )
                .body(saved);
    }

    @Override
    public ResponseEntity<EmployeePositionDto> findById(@PathVariable("id") Long employeePositionId) {
        EmployeePositionDto employeePositionDto = employeePositionService.findById(employeePositionId);

        return ResponseEntity.ok(employeePositionDto);
    }

    @Override
    public ResponseEntity<List<EmployeePositionDto>> findAll() {
        List<EmployeePositionDto> employeePositions = employeePositionService.findAll();

        return ResponseEntity.ok(employeePositions);
    }

    @Override
    public ResponseEntity<Void> delete(@PathVariable("id") Long employeePositionId) {
        employeePositionService.delete(employeePositionId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
