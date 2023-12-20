package com.example.springboard.common.exception;

public class GlobalException extends RuntimeException {

    private String params;

    public GlobalException() {
        super();
    }

    public GlobalException(String message) {
        super(message);
    }

    public GlobalException(String message, String params) {
        super(message);
        this.params = params;
    }

    public GlobalException(String message, Throwable cause, String params) {
        super(message, cause);
        this.params = params;
    }

    public GlobalException(Throwable cause, String params) {
        super(cause);
        this.params = params;
    }

    public String getParams() {
        return params;
    }
}
