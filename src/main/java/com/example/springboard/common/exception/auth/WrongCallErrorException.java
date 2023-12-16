package com.example.springboard.common.exception.auth;

import com.example.springboard.common.exception.BaseLoggingException;

public class WrongCallErrorException extends BaseLoggingException {

    public WrongCallErrorException() {
        super("옳바르지 않은 접근입니다.", LOG_LEVEL.WARN);
    }
}
