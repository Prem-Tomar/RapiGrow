package com.rapigrow.main.common.exceptions.handlers;

import com.google.firebase.FirebaseException;
import com.rapigrow.main.common.dto.ResponseDTO;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
@Order(10)
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FirebaseException.class)
    public ResponseEntity<ResponseDTO<String>> handleFirebaseException(FirebaseException ex, WebRequest request) {
        String message = "We are having facing issues with out identity provider!";
        var responseEnvelop = new ResponseDTO<>(ex.getLocalizedMessage(), "", ex.getStackTrace());
        return ResponseEntity.status(ex.getHttpResponse().getStatusCode()).body(responseEnvelop);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ResponseDTO<String>> handleGlobalException(Exception ex, WebRequest request) {
        String message = "Something went wrong that we don't understand yet, don't worry we will be back to normal state in no time!";
        var responseEnvelop = new ResponseDTO<>(message, ex.getLocalizedMessage(), ex.getCause());
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(responseEnvelop);
    }
}
