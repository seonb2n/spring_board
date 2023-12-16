package com.example.springboard.common.exception.article;

import com.example.springboard.common.exception.BaseLoggingException;

public class ArticleCreateErrorException extends BaseLoggingException {

    public ArticleCreateErrorException() {
        super("게시물 생성에 실패했습니다.", LOG_LEVEL.ERROR);
    }

}
