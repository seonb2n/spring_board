package com.example.springboard.common.exception.board;

import com.example.springboard.common.exception.BaseLoggingException;

public class DeleteBoardErrorException extends BaseLoggingException {

    public DeleteBoardErrorException() {
        super("게시판 삭제에 실패했습니다.", LOG_LEVEL.ERROR);
    }

}
