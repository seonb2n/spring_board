package com.example.springboard.common.exception;

import org.springframework.boot.logging.LogLevel;

public class GlobalException extends RuntimeException {

    private String params;
    private LogLevel logLevel;

    public GlobalException() {
        super();
    }

    public GlobalException(String message) {
        super(message);
        this.logLevel = LogLevel.INFO;
    }

    public GlobalException(String message, String params) {
        super(message);
        this.params = params;
    }

    public GlobalException(String message, String params, LogLevel logLevel) {
        super(message);
        this.params = params;
        this.logLevel = logLevel;
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

    public LogLevel getLogLevel() {
        return logLevel;
    }
}
