package com.example.springboard.common.exception.user;

import com.example.springboard.common.exception.GlobalException;

/**
 * 닉네임으로 사용자 찾기에 실패했습니다. 존재하지 않는 사용자입니다.
 */
public class UserNotFoundByNicknameException extends GlobalException {

    public UserNotFoundByNicknameException() {
    }

    public UserNotFoundByNicknameException(String message, String params) {
        super(message, params);
    }

    public UserNotFoundByNicknameException(String message, Throwable cause, String params) {
        super(message, cause, params);
    }

    public UserNotFoundByNicknameException(Throwable cause, String params) {
        super(cause, params);
    }
}
