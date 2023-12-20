package com.example.springboard.common.exception.auth;

import com.example.springboard.common.exception.GlobalException;

/**
 * 아이디 혹은 비밀번호가 잘못됐습니다.
 */
public class LoginErrorException extends GlobalException {

    public LoginErrorException() {
    }

    public LoginErrorException(String message, String params) {
        super(message, params);
    }

    public LoginErrorException(String message, Throwable cause, String params) {
        super(message, cause, params);
    }

    public LoginErrorException(Throwable cause, String params) {
        super(cause, params);
    }
}
