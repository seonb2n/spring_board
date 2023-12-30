package com.example.springboard.common.exception.auth;

import com.example.springboard.common.exception.GlobalException;

/**
 * 옳바르지 않은 접근입니다.
 */
public class WrongCallErrorException extends GlobalException {

    public WrongCallErrorException() {
    }

    public WrongCallErrorException(String message, String params) {
        super(message, params);
    }

    public WrongCallErrorException(String message, Throwable cause, String params) {
        super(message, cause, params);
    }

    public WrongCallErrorException(Throwable cause, String params) {
        super(cause, params);
    }
}
