package com.rapigrow.main.common.exceptions;

import lombok.ToString;

@ToString(callSuper = true)
public class UserNotAuthorisedException extends RapiGrowRuntimeException {

    public UserNotAuthorisedException(int statusCode, String message, Exception ex) {
        super(statusCode, message, ex);
    }
}
