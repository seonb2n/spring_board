package com.example.springboard.common.exception.board;

import com.example.springboard.common.exception.BaseLoggingException;

public class GetListException extends BaseLoggingException {

    public GetListException() {
        super("게시판 목록을 가져오지 못했습니다.", LOG_LEVEL.ERROR);
    }

}
