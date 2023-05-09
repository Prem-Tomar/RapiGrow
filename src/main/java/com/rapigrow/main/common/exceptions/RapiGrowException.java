package com.rapigrow.main.common.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString(callSuper = true)
public class RapiGrowException extends Exception {
    private final String message;
    private final HttpStatus statusCode;

    public RapiGrowException(HttpStatus statusCode, String message, Exception ex) {
        super(ex);
        this.statusCode = statusCode;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
