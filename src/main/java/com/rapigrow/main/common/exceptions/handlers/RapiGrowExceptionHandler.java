package com.rapigrow.main.common.exceptions.handlers;

import com.rapigrow.main.common.exceptions.RapiGrowRuntimeException;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Order(0)
public class RapiGrowExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {RapiGrowRuntimeException.class})
    public ResponseEntity<Object> handleRapiGrowRuntimeException(RapiGrowRuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getBody(), new HttpHeaders(), HttpStatusCode.valueOf(ex.getStatusCode()), request);
    }


}
