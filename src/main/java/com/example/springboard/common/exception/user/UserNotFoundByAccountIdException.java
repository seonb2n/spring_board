package com.example.springboard.common.exception.user;

import com.example.springboard.common.exception.GlobalException;

/**
 * 아이디 찾기에 실패했습니다. 존재하지 않는 사용자입니다.
 */
public class UserNotFoundByAccountIdException extends GlobalException {

    public UserNotFoundByAccountIdException() {
        super("UserNotFoundByAccountIdException");
    }

    public UserNotFoundByAccountIdException(String message, String params) {
        super(message, params);
    }

    public UserNotFoundByAccountIdException(String message, Throwable cause, String params) {
        super(message, cause, params);
    }

    public UserNotFoundByAccountIdException(Throwable cause, String params) {
        super(cause, params);
    }
}
