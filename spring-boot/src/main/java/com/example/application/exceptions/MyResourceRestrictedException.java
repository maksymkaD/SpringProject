package com.example.application.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class MyResourceRestrictedException extends RuntimeException {
    public MyResourceRestrictedException() {
        super();
    }
    public MyResourceRestrictedException(String message, Throwable cause) {
        super(message, cause);
    }
    public MyResourceRestrictedException(String message) {
        super(message);
    }
    public MyResourceRestrictedException(Throwable cause) {
        super(cause);
    }
}
