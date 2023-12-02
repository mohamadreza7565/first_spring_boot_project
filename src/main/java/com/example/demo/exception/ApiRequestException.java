package com.example.demo.exception;

public class ApiRequestException extends RuntimeException{
    private final Object object;
    public ApiRequestException(String message,Object object) {
        super(message);
        this.object = object;
    }

    public ApiRequestException(String message, Throwable cause,Object object) {
        super(message, cause);
        this.object = object;
    }

    public Object getObject() {
        return object;
    }
}
