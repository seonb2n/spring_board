package com.example.springboard.common.exception.board;

import com.example.springboard.common.exception.BaseLoggingException;

public class GetArticleListErrorException extends BaseLoggingException {

    public GetArticleListErrorException() {
        super("게시물 목록을 가져오지 못했습니다.", LOG_LEVEL.ERROR);
    }

}
