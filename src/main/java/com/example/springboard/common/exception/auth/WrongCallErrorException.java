package com.example.springboard.common.exception.auth;

import com.example.springboard.common.exception.BaseWarnException;

public class WrongCallErrorException extends BaseWarnException {

    public WrongCallErrorException() {
        super("옳바르지 않은 접근입니다.");
    }
}
