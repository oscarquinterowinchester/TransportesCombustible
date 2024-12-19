package com.appchoferes.nomina.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.appchoferes.nomina.errors.ErrorInternoException;
import com.appchoferes.nomina.errors.NotFoundException;

@ControllerAdvice
public class ExceptionsController {
    
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> manageErrorNotFoundException(NotFoundException ex){
        Map<String, Object> body = new HashMap<>();
        body.put("message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(ErrorInternoException.class)
    public ResponseEntity<?> manejarErrorInternoException(ErrorInternoException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getFieldErrors().stream()
                              .map(error -> error.getDefaultMessage())
                              .findFirst()
                              .orElse("Validation error occurred");
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }
}
