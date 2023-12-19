package com.example.springboard.common.exception.user;

import com.example.springboard.common.exception.GlobalException;

/**
 * 이미 가입된 계정입니다.
 */
public class AlreadyJoinedUserErrorException extends GlobalException {

    public AlreadyJoinedUserErrorException() {
    }

    public AlreadyJoinedUserErrorException(String message) {
        super(message);
    }

    public AlreadyJoinedUserErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlreadyJoinedUserErrorException(Throwable cause) {
        super(cause);
    }
}
