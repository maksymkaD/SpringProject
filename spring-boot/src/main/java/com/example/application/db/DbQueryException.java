package com.example.application.db;

public class DbQueryException extends Exception{
    public DbQueryException(String errorMessage) {
        super(errorMessage);
    }
}
