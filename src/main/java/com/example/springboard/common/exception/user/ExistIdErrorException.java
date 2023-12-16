package com.example.springboard.common.exception.user;

import com.example.springboard.common.exception.BaseLoggingException;

public class ExistIdErrorException extends BaseLoggingException {

    public ExistIdErrorException() {
        super("이미 존재하는 ID 입니다.", LOG_LEVEL.INFO);
    }

}
