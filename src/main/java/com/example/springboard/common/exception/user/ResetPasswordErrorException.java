package com.example.springboard.common.exception.user;

import com.example.springboard.common.exception.BaseErrorException;

public class ResetPasswordErrorException extends BaseErrorException {
    public ResetPasswordErrorException() {
        super("비밀번호 초기화에 실패했습니다.");
    }
}
