package com.example.springboard.common.exception.article;

import com.example.springboard.common.exception.GlobalException;

/**
 * 게시물 제목이 옳바르지 않습니다. 제목 100자 이내
 */
public class ArticleTitleFormatErrorException extends GlobalException {

    public ArticleTitleFormatErrorException() {
    }

    public ArticleTitleFormatErrorException(String message, String params) {
        super(message, params);
    }

    public ArticleTitleFormatErrorException(String message, Throwable cause, String params) {
        super(message, cause, params);
    }

    public ArticleTitleFormatErrorException(Throwable cause, String params) {
        super(cause, params);
    }
}
