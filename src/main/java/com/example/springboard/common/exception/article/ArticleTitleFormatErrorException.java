package com.example.springboard.common.exception.article;

import com.example.springboard.common.exception.BaseLoggingException;

public class ArticleTitleFormatErrorException extends BaseLoggingException {

    public ArticleTitleFormatErrorException() {
        super("게시물 제목이 옳바르지 않습니다. 제목 100자 이내", LOG_LEVEL.INFO);
    }

}
