package com.example.springboard.common.exception.user;

import com.example.springboard.common.exception.BaseLoggingException;

public class ResetPasswordErrorException extends BaseLoggingException {
    public ResetPasswordErrorException() {
        super("비밀번호 초기화에 실패했습니다.", LOG_LEVEL.ERROR);
    }
}
