package com.example.demo.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiException {

    private Boolean error;
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;
    private final ZonedDateTime zonedDateTime;
    private final Object data;

    public ApiException(String message, Throwable throwable, HttpStatus httpStatus, ZonedDateTime zonedDateTime, Object data) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
        this.zonedDateTime = zonedDateTime;
        this.data = data;
        this.error = true;
    }

    public Boolean getError() {
        return error;
    }

    public Object getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    @JsonIgnore
    public Throwable getThrowable() {
        return throwable;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @JsonIgnore
    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }

    @Override
    public String toString() {
        return "ApiException{" +
                "message='" + message + '\'' +
                ", throwable=" + throwable +
                ", httpStatus=" + httpStatus +
                ", zonedDateTime=" + zonedDateTime +
                '}';
    }
}
