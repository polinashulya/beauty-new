package com.company.controller.exception;

import com.company.service.exception.AbstractException;
import com.company.service.exception.ResourceNotFoundException;
import com.company.service.exception.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler({AbstractException.class})
    public ResponseEntity<ErrorMessage> handleException(AbstractException ex) {
        return
                new ResponseEntity<>(
                        new ErrorMessage(ex.getStatusCode().getCode(), ex.getMessage()),
                        HttpStatus.valueOf(ex.getStatusCode().getCode())
                );
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorMessageList> handleException(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult()
                .getAllErrors()
                .forEach((error) -> {
                    String fieldName = ((FieldError) error).getField();
                    String errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });

        return ResponseEntity.badRequest()
                .body(
                        new ErrorMessageList(HttpStatus.BAD_REQUEST.value(), "Parameters are not valid.", errors)
                );
    }


}
