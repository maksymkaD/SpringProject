package com.example.application.exceptions;

import org.springframework.http.HttpStatus;

import java.net.HttpCookie;
import java.time.ZonedDateTime;

public class NotFoundException {

    private final String message = "This data was not found.";
    private final Throwable throwable;
    private final HttpStatus httpStatus;
    private final ZonedDateTime time;

    public NotFoundException(String message, Throwable throwable, HttpStatus httpStatus, ZonedDateTime time) {
        this.throwable = throwable;
        this.httpStatus = httpStatus;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTime() {
        return time;
    }
}
