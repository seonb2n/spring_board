package com.example.springboard.common.exception.user;

import com.example.springboard.common.exception.BaseInfoException;

public class AlreadyJoinedUserErrorException extends BaseInfoException {

    public AlreadyJoinedUserErrorException() {
        super("이미 가입된 계정입니다.");
    }

}
