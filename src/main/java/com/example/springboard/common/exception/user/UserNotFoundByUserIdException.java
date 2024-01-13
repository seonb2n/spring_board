package com.example.springboard.common.exception.user;

import com.example.springboard.common.exception.GlobalException;

/**
 * User 찾기에 실패했습니다. 존재하지 않는 사용자입니다.
 */
public class UserNotFoundByUserIdException extends GlobalException {

    public UserNotFoundByUserIdException() {
    }

    public UserNotFoundByUserIdException(String message, String params) {
        super(message, params);
    }

    public UserNotFoundByUserIdException(String message, Throwable cause, String params) {
        super(message, cause, params);
    }

    public UserNotFoundByUserIdException(Throwable cause, String params) {
        super(cause, params);
    }
}
