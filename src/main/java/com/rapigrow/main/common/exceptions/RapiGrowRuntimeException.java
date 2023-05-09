package com.rapigrow.main.common.exceptions;

import lombok.ToString;
import org.slf4j.Marker;
import org.springframework.http.HttpStatus;

@ToString(callSuper = true)
public class RapiGrowRuntimeException extends RuntimeException {
    private final String message;
    private final HttpStatus statusCode;
    private final Object body;
    private final Marker marker;

    public <T> RapiGrowRuntimeException(HttpStatus statusCode, String message, Exception ex, T body, Marker marker) {
        super(ex);
        this.statusCode = statusCode;
        this.message = message;
        this.body = body;
        this.marker = marker;
    }
    public <T> RapiGrowRuntimeException(HttpStatus statusCode, String message, Exception ex, T body) {
        super(ex);
        this.statusCode = statusCode;
        this.message = message;
        this.body = body;
        this.marker=null;
    }

    public <T> RapiGrowRuntimeException(HttpStatus statusCode, String message, Exception ex) {
        super(ex);
        this.statusCode = statusCode;
        this.message = message;
        this.body = null;
        this.marker=null;
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
