package com.example.springboard.common.exception.user;

import com.example.springboard.common.exception.GlobalException;

/**
 * 아이디 찾기에 실패했습니다. 존재하지 않는 사용자입니다.
 */
public class FindIdNoUserErrorException extends GlobalException {
    public FindIdNoUserErrorException() {
    }

    public FindIdNoUserErrorException(String message) {
        super(message);
    }

    public FindIdNoUserErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public FindIdNoUserErrorException(Throwable cause) {
        super(cause);
    }
}
