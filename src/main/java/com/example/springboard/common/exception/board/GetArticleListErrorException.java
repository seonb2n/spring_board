package com.example.springboard.common.exception.board;

import com.example.springboard.common.exception.BaseErrorException;

public class GetArticleListErrorException extends BaseErrorException {

    public GetArticleListErrorException() {
        super("게시물 목록을 가져오지 못했습니다.");
    }

}
