package com.rapigrow.main.common.exceptions;

import lombok.ToString;

@ToString(callSuper = true)
public class UserNotAuthorisedException extends RapiGrowRuntimeException {


    public <T> UserNotAuthorisedException(int statusCode, String message, T body, Exception ex) {
        super(statusCode, message, body, ex);
    }
}
