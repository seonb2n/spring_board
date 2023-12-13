package com.example.springboard.common.exception.board;

import com.example.springboard.common.exception.BaseErrorException;

public class CreateBoardErrorException extends BaseErrorException {

    public CreateBoardErrorException() {
        super("게시판 생성을 실패했습니다.");
    }

}
