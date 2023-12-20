package com.example.springboard.common.exception.user;

import com.example.springboard.common.exception.GlobalException;

/**
 * 이미 가입된 계정입니다.
 */
public class AlreadyJoinedUserErrorException extends GlobalException {

    public AlreadyJoinedUserErrorException() {
    }

    public AlreadyJoinedUserErrorException(String message, String params) {
        super(message, params);
    }

    public AlreadyJoinedUserErrorException(String message, Throwable cause, String params) {
        super(message, cause, params);
    }

    public AlreadyJoinedUserErrorException(Throwable cause, String params) {
        super(cause, params);
    }
}
