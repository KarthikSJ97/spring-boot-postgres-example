package com.example.springbootwithpostgresql.commons;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomNotFoundException.class)
    public final ResponseEntity<Object> handleNotFoundException(CustomNotFoundException ex, HttpServletRequest req) {
        return new ResponseEntity<>(ex.getLocalizedMessage(), HttpStatus.NOT_FOUND);
    }
}
