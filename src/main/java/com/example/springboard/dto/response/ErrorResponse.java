package com.example.springboard.dto.response;

import com.example.springboard.util.enums.ErrorTypeWithRequest;

public class ErrorResponse {

    private int statusCode;

    public ErrorResponse(ErrorTypeWithRequest errorCode) {
        this.statusCode = errorCode.getCode();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
