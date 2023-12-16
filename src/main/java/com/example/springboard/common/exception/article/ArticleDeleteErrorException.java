package com.example.springboard.common.exception.article;

import com.example.springboard.common.exception.BaseLoggingException;

public class ArticleDeleteErrorException extends BaseLoggingException {

    public ArticleDeleteErrorException() {
        super("게시물 삭제에 실패했습니다.", LOG_LEVEL.ERROR);
    }

}
