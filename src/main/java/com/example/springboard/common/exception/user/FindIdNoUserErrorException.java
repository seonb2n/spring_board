package com.example.springboard.common.exception.user;

import com.example.springboard.common.exception.BaseLoggingException;

public class FindIdNoUserErrorException extends BaseLoggingException {
    public FindIdNoUserErrorException() {
        super("아이디 찾기에 실패했습니다. 존재하지 않는 사용자입니다.", LOG_LEVEL.INFO);
    }
}
