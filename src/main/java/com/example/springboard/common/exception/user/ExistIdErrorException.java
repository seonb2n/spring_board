package com.example.springboard.common.exception.user;

import com.example.springboard.common.exception.GlobalException;

/**
 * 이미 존재하는 ID 입니다.
 */
public class ExistIdErrorException extends GlobalException {

    public ExistIdErrorException() {
    }

    public ExistIdErrorException(String message) {
        super(message);
    }

    public ExistIdErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExistIdErrorException(Throwable cause) {
        super(cause);
    }
}
