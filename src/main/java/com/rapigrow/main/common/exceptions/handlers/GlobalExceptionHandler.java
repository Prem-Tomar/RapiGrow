package com.rapigrow.main.common.exceptions.handlers;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
@Order(10)
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    public ResponseEntity<Object> handleGlobalException(RuntimeException ex, WebRequest request) {
        String message = "Something went wrong that we don't understand yet, don't worry we will be back to normal in no time!";
        return handleExceptionInternal(ex, message, new HttpHeaders(), INTERNAL_SERVER_ERROR, request);
    }
}
