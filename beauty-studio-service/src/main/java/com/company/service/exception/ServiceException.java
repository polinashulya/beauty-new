package com.company.service.exception;

public class ServiceException extends AbstractException {

    public ServiceException(HttpStatusCode statusCode, String message) {
        super(statusCode, message);
    }

    public ServiceException(HttpStatusCode statusCode, String message, Exception ex) {
        super(statusCode, message, ex);
    }
}
