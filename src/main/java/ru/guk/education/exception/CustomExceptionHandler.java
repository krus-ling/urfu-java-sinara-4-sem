package ru.guk.education.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleServerError(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_GATEWAY)
                .body(Map.of(
                "error", "Bad Gateway🤯",
                        "message", ex.getMessage()));
    }
}
