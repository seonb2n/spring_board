package com.example.springboard.common.exception.user;

import com.example.springboard.common.exception.BaseInfoException;

public class ExistIdErrorException extends BaseInfoException {

    public ExistIdErrorException() {
        super("이미 존재하는 ID 입니다.");
    }

}
