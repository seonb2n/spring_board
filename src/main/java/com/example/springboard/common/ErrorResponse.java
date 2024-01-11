package com.example.springboard.common;

import com.example.springboard.util.enums.ErrorTypeWithRequest;

public class ErrorResponse {

    private int statusCode;
    private String message;

    public ErrorResponse(ErrorTypeWithRequest errorCode, String message) {
        this.statusCode = errorCode.getCode();
        this.message = message != null ? message : errorCode.getMessage();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
