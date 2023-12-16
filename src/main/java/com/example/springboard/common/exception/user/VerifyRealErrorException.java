package com.example.springboard.common.exception.user;

import com.example.springboard.common.exception.BaseLoggingException;

public class VerifyRealErrorException extends BaseLoggingException {

    public VerifyRealErrorException() {
        super("실명 인증에 실패했습니다.", LOG_LEVEL.ERROR);
    }
}
