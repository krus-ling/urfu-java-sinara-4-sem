package ru.guk.education.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleServerError(Exception ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Bad Gateway");
        response.put("message", "Произошла ошибка на сервере🤯");
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(response);
    }
}
