package com.example.springboard.common.exception.auth;

import com.example.springboard.common.exception.GlobalException;

/**
 * 옳바르지 않은 접근입니다.
 */
public class WrongCallErrorException extends GlobalException {
    public WrongCallErrorException() {
    }

    public WrongCallErrorException(String message) {
        super(message);
    }

    public WrongCallErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongCallErrorException(Throwable cause) {
        super(cause);
    }
}
