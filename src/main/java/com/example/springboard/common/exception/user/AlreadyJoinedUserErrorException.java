package com.example.springboard.common.exception.user;

import com.example.springboard.common.exception.BaseLoggingException;

public class AlreadyJoinedUserErrorException extends BaseLoggingException {

    public AlreadyJoinedUserErrorException() {
        super("이미 가입된 계정입니다.", LOG_LEVEL.INFO);
    }

}
