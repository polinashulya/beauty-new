package com.company.service.exception;

public class ResourceNotFoundException extends AbstractException {

    public ResourceNotFoundException(HttpStatusCode statusCode, String message) {
        super(statusCode, message);
    }
}
