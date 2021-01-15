package com.vasileirimia.coinchange.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * RestResponseEntityExceptionHandler
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler {
    @ExceptionHandler(value
            = { RuntimeException.class })
    protected ResponseEntity<Object> handleError(
            RuntimeException ex, WebRequest request) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
