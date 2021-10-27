package com.example.application.exceptions;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class WrongFormatException {


    private final String message = "Wrong format of data!";
    private final Throwable throwable;
    private final HttpStatus httpStatus;
    private final ZonedDateTime time;

    public WrongFormatException(String message, Throwable throwable, HttpStatus httpStatus, ZonedDateTime time) {

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
