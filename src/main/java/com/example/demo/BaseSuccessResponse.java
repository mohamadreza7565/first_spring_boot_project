package com.example.demo;

import com.example.demo.exception.ApiException;
import org.springframework.http.HttpStatus;

public class BaseSuccessResponse<T> {

    boolean error;
    private final String message;
    private final HttpStatus httpStatus;
    private final T data;
    public BaseSuccessResponse( String message, T data) {
        this.error = false;
        this.httpStatus = HttpStatus.OK;
        this.message = message;
        this.data = data;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public boolean isError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
