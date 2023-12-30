package com.example.springboard.common;

import com.example.springboard.util.enums.ErrorCode;
import java.util.Map;

public class ErrorResponse {

    private int status;
    private String code;
    private String msgTitle;
    private String message;
    private Map<String, String> errors;

    public ErrorResponse(ErrorCode errorCode, String message) {
        this.status = errorCode.getStatus();
        this.code = errorCode.name();
        this.message = message != null ? message : errorCode.getMessage();
    }

    public ErrorResponse(ErrorCode errorCode, String msgTitle,
                         String message) {
        this.status = errorCode.getStatus();
        this.code = errorCode.name();
        this.msgTitle = msgTitle != null ? msgTitle : errorCode.getMessage();
        this.message = message != null ? message : errorCode.getMessage();
    }

    public ErrorResponse(ErrorCode errorCode, String message,
                         Map<String, String> errors) {
        this.status = errorCode.getStatus();
        this.code = errorCode.name();
        this.message = message != null ? message : errorCode.getMessage();
        this.errors = errors;
    }

    public int getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getMsgTitle() {
        return msgTitle;
    }

    public String getMessage() {
        return message;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}
