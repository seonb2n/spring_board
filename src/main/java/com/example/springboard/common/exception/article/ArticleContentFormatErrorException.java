package com.example.springboard.common.exception.article;

import com.example.springboard.common.exception.BaseLoggingException;

public class ArticleContentFormatErrorException extends BaseLoggingException {

    public ArticleContentFormatErrorException() {
        super("게시물 내용이 옳바르지 않습니다. 내용 1000자 이내", LOG_LEVEL.INFO);
    }

}
