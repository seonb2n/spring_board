package com.example.springboard.common.exception.user;

import com.example.springboard.common.exception.GlobalException;

/**
 * 비밀번호 초기화에 실패했습니다.
 */
public class ResetPasswordErrorException extends GlobalException {
    public ResetPasswordErrorException() {
    }

    public ResetPasswordErrorException(String message) {
        super(message);
    }

    public ResetPasswordErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResetPasswordErrorException(Throwable cause) {
        super(cause);
    }
}
