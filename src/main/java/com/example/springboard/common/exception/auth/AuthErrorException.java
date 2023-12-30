package com.example.springboard.common.exception.auth;

import com.example.springboard.common.exception.GlobalException;

/**
 * 해당 API 를 호출할 권한이 없습니다.
 */
public class AuthErrorException extends GlobalException {

    public AuthErrorException() {
    }

    public AuthErrorException(String message, String params) {
        super(message, params);
    }

    public AuthErrorException(String message, Throwable cause, String params) {
        super(message, cause, params);
    }

    public AuthErrorException(Throwable cause, String params) {
        super(cause, params);
    }
}
