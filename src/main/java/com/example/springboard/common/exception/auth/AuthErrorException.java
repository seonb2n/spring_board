package com.example.springboard.common.exception.auth;

import com.example.springboard.common.exception.BaseLoggingException;

public class AuthErrorException extends BaseLoggingException {

    public AuthErrorException() {
        super("해당 API 를 호출할 권한이 없습니다.", LOG_LEVEL.WARN);
    }
}
