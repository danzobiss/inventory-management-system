package com.danzobiss.inventory_management_system.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.ResponseEntity.status;

@SuppressWarnings("unused")
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidEntityException(InvalidEntityException ex) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("error", ex.getClass().getSimpleName());
        responseBody.put("errors", ex.getErrorMessages());
        responseBody.put("message", ex.getMessage());

        return status(BAD_REQUEST).body(responseBody);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, Object>> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {

        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("error", "JSON Parse Error");
        responseBody.put("message", ex.getLocalizedMessage()
                .replaceAll(".*JSON parse error:", "")
                .replaceAll("\\(class.*", "")
                .replace("\"", "'")
                .trim());

        return status(BAD_REQUEST).body(responseBody);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleResourceNotFoundException(ResourceNotFoundException ex) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("error", ex.getClass().getSimpleName());
        responseBody.put("message", ex.getMessage());

        return status(BAD_REQUEST).body(responseBody);
    }

}
