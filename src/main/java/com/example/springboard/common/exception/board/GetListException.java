package com.example.springboard.common.exception.board;

import com.example.springboard.common.exception.BaseErrorException;

public class GetListException extends BaseErrorException {

    public GetListException() {
        super("게시판 목록을 가져오지 못했습니다.");
    }

}
