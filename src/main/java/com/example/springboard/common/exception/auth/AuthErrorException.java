package com.example.springboard.common.exception.auth;

import com.example.springboard.common.exception.BaseWarnException;

public class AuthErrorException extends BaseWarnException {

    public AuthErrorException() {
        super("해당 API 를 호출할 권한이 없습니다.");
    }
}
