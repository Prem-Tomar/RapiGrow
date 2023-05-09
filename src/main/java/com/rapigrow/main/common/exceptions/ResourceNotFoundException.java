package com.rapigrow.main.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public class ResourceNotFoundException extends RapiGrowRuntimeException{
    public <T> ResourceNotFoundException(HttpStatus statusCode, String message, T body, Exception ex) {
        super(statusCode, message, body, ex);
    }
}
