package com.example.springboard.dto.response;

import com.example.springboard.util.enums.ErrorTypeWithRequest;

public class ErrorResponse extends CommonResponse<String> {

    String error;

    protected ErrorResponse() {
    }

    private ErrorResponse(ErrorTypeWithRequest responseCode, String error) {
        super(responseCode.getCode(), null);
        this.error = error;
    }

    public static ErrorResponse of(ErrorTypeWithRequest responseCode) {
        return new ErrorResponse(responseCode, responseCode.name());
    }
}
