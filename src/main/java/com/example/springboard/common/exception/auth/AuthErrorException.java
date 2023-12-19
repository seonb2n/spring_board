package com.example.springboard.common.exception.auth;

import com.example.springboard.common.exception.GlobalException;

/**
 * 해당 API 를 호출할 권한이 없습니다.
 */
public class AuthErrorException extends GlobalException {

    public AuthErrorException() {
    }

    public AuthErrorException(String message) {
        super(message);
    }

    public AuthErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthErrorException(Throwable cause) {
        super(cause);
    }
}
