package com.example.springboard.common.exception.board;

import com.example.springboard.common.exception.BaseLoggingException;

public class CreateBoardErrorException extends BaseLoggingException {

    public CreateBoardErrorException() {
        super("게시판 생성을 실패했습니다.", LOG_LEVEL.ERROR);
    }

}
