package com.example.springboard.common.exception.article;

import com.example.springboard.common.exception.BaseLoggingException;

public class ArticleViewErrorException extends BaseLoggingException {

    public ArticleViewErrorException() {
        super("게시물 조회에 실패했습니다.", LOG_LEVEL.ERROR);
    }

}
