package com.example.springboard.dto.response;

import com.example.springboard.util.enums.ErrorTypeWithRequest;

public class ErrorResponse extends CommonResponse<String> {

    protected ErrorResponse() {
    }

    private ErrorResponse(ErrorTypeWithRequest responseCode) {
        super(responseCode.getCode(), null);
    }

    public static ErrorResponse of(ErrorTypeWithRequest responseCode) {
        return new ErrorResponse(responseCode);
    }
}
