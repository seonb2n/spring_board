package com.example.springboard.common.exception.article;

import com.example.springboard.common.exception.GlobalException;

/**
 * 게시물 내용이 옳바르지 않습니다. 내용 1000자 이내
 */
public class ArticleContentFormatErrorException extends GlobalException {

    public ArticleContentFormatErrorException() {
    }

    public ArticleContentFormatErrorException(String message) {
        super(message);
    }

    public ArticleContentFormatErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArticleContentFormatErrorException(Throwable cause) {
        super(cause);
    }
}
