package com.rapigrow.main.common.exceptions.handlers;

import com.rapigrow.main.common.exceptions.RapiGrowRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Order(0)
@Slf4j
public class RapiGrowExceptionHandler extends ResponseEntityExceptionHandler {
// Use this for custom cloud integration of logs
//    private static final Logger LOGGER = LoggerFactory.getLogger(MainApplication.class);

    /**
     * This is handler method for exceptions thrown by Rest Controllers
     *
     * @param ex      Exception object of type {@link RapiGrowRuntimeException}
     * @param request of type {@link WebRequest}
     * @return {@link ResponseEntity}
     * @see ResponseEntityExceptionHandler
     * @see RapiGrowRuntimeException
     */
    @ExceptionHandler(value = {RapiGrowRuntimeException.class})
    public ResponseEntity<Object> handleRapiGrowRuntimeException(RapiGrowRuntimeException ex, WebRequest request) {
        log.error(ex.getMessage(), ex.getBody(), ex);
        return handleExceptionInternal(ex, ex.getBody(), new HttpHeaders(), ex.getStatusCode(), request);
    }


}
