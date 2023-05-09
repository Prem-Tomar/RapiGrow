package com.rapigrow.main.common.exceptions;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends RapiGrowRuntimeException {
    public <T> ResourceNotFoundException(HttpStatus statusCode, String message, Exception ex, T body) {
        super(statusCode, message, ex, body);
    }
}
