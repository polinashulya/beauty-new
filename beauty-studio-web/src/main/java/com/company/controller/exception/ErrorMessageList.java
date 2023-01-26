package com.company.controller.exception;

import lombok.Getter;

import java.util.Map;


@Getter
public class ErrorMessageList extends ErrorMessage {

    private final Map<String, String> errors;

    public ErrorMessageList(Integer code, String error, Map<String, String> errors) {
        super(code, error);
        this.errors = errors;
    }

}
