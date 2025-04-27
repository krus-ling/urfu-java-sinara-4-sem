package ru.guk.education.exception;

public class ApiLimitException extends RuntimeException {

    public ApiLimitException(String message) {
        super(message);
    }
}
