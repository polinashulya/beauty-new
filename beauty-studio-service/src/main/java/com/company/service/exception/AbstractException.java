package com.company.service.exception;

import lombok.Getter;

@Getter
public class AbstractException extends RuntimeException {

    private final HttpStatusCode statusCode;

    public AbstractException(HttpStatusCode statusCode, String error) {
        super(error);
        this.statusCode = statusCode;
    }

    public AbstractException(HttpStatusCode statusCode, String error, Exception exception) {
        super(error, exception);
        this.statusCode = statusCode;
    }

}
