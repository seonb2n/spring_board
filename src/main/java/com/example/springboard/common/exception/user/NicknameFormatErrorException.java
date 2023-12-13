package com.example.springboard.common.exception.user;

import com.example.springboard.common.exception.BaseInfoException;

public class NicknameFormatErrorException extends BaseInfoException {

    public NicknameFormatErrorException() {
        super("닉네임 형식이 옳바르지 않습니다. 2-6자리로 구성되어야 합니다.");
    }
}
