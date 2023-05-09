package com.rapigrow.main.common.exceptions;

public class ResourceNotFoundException extends RapiGrowRuntimeException{
    public <T> ResourceNotFoundException(int statusCode, String message, T body, Exception ex) {
        super(statusCode, message, body, ex);
    }
}
