package com.example.demo.exception;


public class NotFoundException extends RuntimeException{

    private final Object object;
    public NotFoundException(String message,Object object) {
        super(message);
        this.object = object;
    }

    public Object getObject() {
        return object;
    }
}
