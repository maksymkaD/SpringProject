package com.example.application.exceptions;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class TestTeacherException {


    private final String message = "We can`t return list of teachers";
    private final Throwable throwable;
    private final HttpStatus httpStatus;
    private final ZonedDateTime time;

    public TestTeacherException(String message, Throwable throwable, HttpStatus httpStatus, ZonedDateTime time) {

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
