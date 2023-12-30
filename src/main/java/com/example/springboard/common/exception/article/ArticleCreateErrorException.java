package com.example.springboard.common.exception.article;

import com.example.springboard.common.exception.GlobalException;

/**
 * 게시물 생성에 실패했습니다.
 */
public class ArticleCreateErrorException extends GlobalException {

    public ArticleCreateErrorException() {
    }

    public ArticleCreateErrorException(String message, String params) {
        super(message, params);
    }

    public ArticleCreateErrorException(String message, Throwable cause, String params) {
        super(message, cause, params);
    }

    public ArticleCreateErrorException(Throwable cause, String params) {
        super(cause, params);
    }
}
