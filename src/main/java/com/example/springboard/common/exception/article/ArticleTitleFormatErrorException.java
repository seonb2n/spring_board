package com.example.springboard.common.exception.article;

import com.example.springboard.common.exception.GlobalException;

/**
 * 게시물 제목이 옳바르지 않습니다. 제목 100자 이내
 */
public class ArticleTitleFormatErrorException extends GlobalException {

    public ArticleTitleFormatErrorException() {
    }

    public ArticleTitleFormatErrorException(String message) {
        super(message);
    }

    public ArticleTitleFormatErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArticleTitleFormatErrorException(Throwable cause) {
        super(cause);
    }
}
