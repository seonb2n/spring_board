package com.example.springboard.common.exception.auth;

import com.example.springboard.common.exception.GlobalException;

/**
 * 아이디 혹은 비밀번호가 잘못됐습니다.
 */
public class LoginErrorException extends GlobalException {

    public LoginErrorException() {
    }

    public LoginErrorException(String message) {
        super(message);
    }

    public LoginErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginErrorException(Throwable cause) {
        super(cause);
    }
}
