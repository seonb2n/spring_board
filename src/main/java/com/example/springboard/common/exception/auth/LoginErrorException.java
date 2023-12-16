package com.example.springboard.common.exception.auth;

import com.example.springboard.common.exception.BaseLoggingException;

public class LoginErrorException extends BaseLoggingException {

    public LoginErrorException() {
        super("아이디 혹은 비밀번호가 잘못됐습니다.", LOG_LEVEL.INFO);
    }

}
