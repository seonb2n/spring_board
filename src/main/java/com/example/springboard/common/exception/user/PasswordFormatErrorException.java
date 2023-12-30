package com.example.springboard.common.exception.user;

import com.example.springboard.common.exception.GlobalException;

/**
 * 비밀번호 형식이 옳바르지 않습니다. 영어, 숫자, 특수문자가 1개 이상씩 포함된 9-13 자리로 구성되어야 합니다.
 */
public class PasswordFormatErrorException extends GlobalException {

    public PasswordFormatErrorException() {
    }

    public PasswordFormatErrorException(String message, String params) {
        super(message, params);
    }

    public PasswordFormatErrorException(String message, Throwable cause, String params) {
        super(message, cause, params);
    }

    public PasswordFormatErrorException(Throwable cause, String params) {
        super(cause, params);
    }
}
