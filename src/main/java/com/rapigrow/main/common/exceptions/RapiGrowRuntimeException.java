package com.rapigrow.main.common.exceptions;

import lombok.Getter;
import lombok.ToString;

@ToString(callSuper = true)
public class RapiGrowRuntimeException extends RuntimeException{
    private final String message;
    private final int statusCode;
    public RapiGrowRuntimeException(int statusCode, String message, Exception ex) {
        super(ex);
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
