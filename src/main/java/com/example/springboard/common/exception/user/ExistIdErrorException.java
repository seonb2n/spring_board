package com.example.springboard.common.exception.user;

import com.example.springboard.common.exception.GlobalException;

/**
 * 이미 존재하는 ID 입니다.
 */
public class ExistIdErrorException extends GlobalException {

    public ExistIdErrorException() {
    }

    public ExistIdErrorException(String message, String params) {
        super(message, params);
    }

    public ExistIdErrorException(String message, Throwable cause, String params) {
        super(message, cause, params);
    }

    public ExistIdErrorException(Throwable cause, String params) {
        super(cause, params);
    }
}
