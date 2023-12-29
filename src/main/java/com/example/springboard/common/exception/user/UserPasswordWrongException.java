package com.example.springboard.common.exception.user;

import com.example.springboard.common.exception.GlobalException;

/**
 * 사용자 비밀번호가 잘못됐습니다.
 */
public class UserPasswordWrongException extends GlobalException {

    public UserPasswordWrongException() {
    }

    public UserPasswordWrongException(String message, String params) {
        super(message, params);
    }

    public UserPasswordWrongException(String message, Throwable cause, String params) {
        super(message, cause, params);
    }

    public UserPasswordWrongException(Throwable cause, String params) {
        super(cause, params);
    }
}
