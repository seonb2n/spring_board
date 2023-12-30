package com.example.springboard.common.exception.user;

import com.example.springboard.common.exception.GlobalException;

/**
 * 실명 인증에 실패했습니다.
 */
public class VerifyRealErrorException extends GlobalException {

    public VerifyRealErrorException() {
    }

    public VerifyRealErrorException(String message, String params) {
        super(message, params);
    }

    public VerifyRealErrorException(String message, Throwable cause, String params) {
        super(message, cause, params);
    }

    public VerifyRealErrorException(Throwable cause, String params) {
        super(cause, params);
    }
}
