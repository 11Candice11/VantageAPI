package com.vantage.elitewealth.exception;

import org.springframework.http.HttpStatus;

public class EliteWealthException extends RuntimeException {

    private final HttpStatus status;

    public EliteWealthException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public EliteWealthException(String message, HttpStatus status, Throwable cause) {
        super(message, cause);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
