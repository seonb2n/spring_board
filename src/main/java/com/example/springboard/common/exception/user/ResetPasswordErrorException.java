package com.example.springboard.common.exception.user;

import com.example.springboard.common.exception.GlobalException;

/**
 * 비밀번호 초기화에 실패했습니다.
 */
public class ResetPasswordErrorException extends GlobalException {

    public ResetPasswordErrorException() {
    }

    public ResetPasswordErrorException(String message, String params) {
        super(message, params);
    }

    public ResetPasswordErrorException(String message, Throwable cause, String params) {
        super(message, cause, params);
    }

    public ResetPasswordErrorException(Throwable cause, String params) {
        super(cause, params);
    }
}
