package com.example.application.exceptions;

public class CustomRequestException extends RuntimeException{

    public CustomRequestException(String message)
    {
        super(message);
    }

    public CustomRequestException(String message, Throwable cause)
    {
        super(message, cause);
    }



}
