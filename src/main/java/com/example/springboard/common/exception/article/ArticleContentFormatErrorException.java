package com.example.springboard.common.exception.article;

import com.example.springboard.common.exception.GlobalException;

/**
 * 게시물 내용이 옳바르지 않습니다. 내용 1000자 이내
 */
public class ArticleContentFormatErrorException extends GlobalException {

    public ArticleContentFormatErrorException() {
    }

    public ArticleContentFormatErrorException(String message, String params) {
        super(message, params);
    }

    public ArticleContentFormatErrorException(String message, Throwable cause, String params) {
        super(message, cause, params);
    }

    public ArticleContentFormatErrorException(Throwable cause, String params) {
        super(cause, params);
    }

}
