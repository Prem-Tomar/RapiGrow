package com.rapigrow.main.common.exceptions;

import lombok.Getter;
import lombok.ToString;

@ToString(callSuper = true)
public class RapiGrowRuntimeException extends RuntimeException {
    private final String message;
    private final int statusCode;
    private final Object body;

    public <T> RapiGrowRuntimeException(int statusCode, String message, T body, Exception ex) {
        super(ex);
        this.statusCode = statusCode;
        this.message = message;
        this.body = body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public Object getBody() {
        return body;
    }
}
