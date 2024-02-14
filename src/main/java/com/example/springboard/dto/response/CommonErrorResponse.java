package com.example.springboard.dto.response;

import com.example.springboard.util.enums.ErrorTypeWithRequest;

public class CommonErrorResponse extends CommonResponse<String> {

    String error;

    protected CommonErrorResponse() {
    }

    private CommonErrorResponse(ErrorTypeWithRequest responseCode, String error) {
        super(responseCode.getCode(), null);
        this.error = error;
    }

    private CommonErrorResponse(int code, String error) {
        super(code, null);
        this.error = error;
    }

    public static CommonErrorResponse of(ErrorTypeWithRequest responseCode) {
        return new CommonErrorResponse(responseCode, responseCode.name());
    }

    public static CommonErrorResponse of(int code, String error) {
        return new CommonErrorResponse(code, error);
    }
}
