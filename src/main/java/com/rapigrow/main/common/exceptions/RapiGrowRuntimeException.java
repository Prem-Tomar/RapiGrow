package com.rapigrow.main.common.exceptions;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@ToString(callSuper = true)
public class RapiGrowRuntimeException extends RuntimeException {
    private final String message;
    private final HttpStatus statusCode;
    private final Object body;

    public <T> RapiGrowRuntimeException(HttpStatus statusCode, String message, T body, Exception ex) {
        super(ex);
        this.statusCode = statusCode;
        this.message = message;
        this.body = body;
    }

    public HttpStatus getStatusCode() {
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
