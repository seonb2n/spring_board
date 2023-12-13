package com.example.springboard.common.exception.user;

import com.example.springboard.common.exception.BaseErrorException;

public class VerifyRealErrorException extends BaseErrorException {

    public VerifyRealErrorException() {
        super("실명 인증에 실패했습니다.");
    }
}
