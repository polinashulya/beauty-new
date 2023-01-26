package com.company.service.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum HttpStatusCode {
    BAD_REQUEST(400),
    NOT_FOUND(404),
    CONFLICT(409),

    SERVER_ERROR(500);

    private int code;

    public HttpStatusCode getHttpStatusByCode(int code) {
        return Arrays.stream(values())
                .filter(it -> it.code == code)
                .findFirst()
                .orElseThrow(() -> new ServiceException(HttpStatusCode.SERVER_ERROR, "Enum constant not found"));
    }

}
