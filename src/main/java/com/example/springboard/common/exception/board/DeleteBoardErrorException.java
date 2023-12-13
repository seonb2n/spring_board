package com.example.springboard.common.exception.board;

import com.example.springboard.common.exception.BaseErrorException;

public class DeleteBoardErrorException extends BaseErrorException {

    public DeleteBoardErrorException() {
        super("게시판 삭제에 실패했습니다.");
    }

}
