package com.rapigrow.main.common.exceptions;

import lombok.ToString;
import org.springframework.http.HttpStatus;

@ToString(callSuper = true)
public class UserNotAuthorisedException extends RapiGrowRuntimeException {


    public <T> UserNotAuthorisedException(HttpStatus statusCode, String message, T body, Exception ex) {
        super(statusCode, message, body, ex);
    }
}
