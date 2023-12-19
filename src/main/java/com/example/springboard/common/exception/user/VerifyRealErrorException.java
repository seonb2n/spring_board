package com.example.springboard.common.exception.user;

import com.example.springboard.common.exception.GlobalException;

/**
 * 실명 인증에 실패했습니다.
 */
public class VerifyRealErrorException extends GlobalException {

    public VerifyRealErrorException() {
    }

    public VerifyRealErrorException(String message) {
        super(message);
    }

    public VerifyRealErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public VerifyRealErrorException(Throwable cause) {
        super(cause);
    }
}
