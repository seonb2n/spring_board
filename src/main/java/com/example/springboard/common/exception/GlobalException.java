package com.example.springboard.common.exception;

import com.example.springboard.util.enums.ErrorTypeWithRequest;
import java.util.Map;

public class GlobalException extends RuntimeException {

    private Map<String, Object> paramMap;
    private ErrorTypeWithRequest errorType;

    public GlobalException(Map<String, Object> paramMap, ErrorTypeWithRequest errorType) {
        this.paramMap = paramMap;
        this.errorType = errorType;
    }

    public Map<String, Object> getParamMap() {
        return paramMap;
    }

    public ErrorTypeWithRequest getErrorType() {
        return errorType;
    }

}
