package com.example.springboard.common.exception.user;

import com.example.springboard.common.exception.GlobalException;

/**
 * 닉네임 형식이 옳바르지 않습니다. 2-6자리로 구성되어야 합니다.
 */
public class NicknameFormatErrorException extends GlobalException {

    public NicknameFormatErrorException() {
    }

    public NicknameFormatErrorException(String message, String params) {
        super(message, params);
    }

    public NicknameFormatErrorException(String message, Throwable cause, String params) {
        super(message, cause, params);
    }

    public NicknameFormatErrorException(Throwable cause, String params) {
        super(cause, params);
    }
}
