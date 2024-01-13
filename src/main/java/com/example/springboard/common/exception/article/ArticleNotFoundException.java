package com.example.springboard.common.exception.article;

import com.example.springboard.common.exception.GlobalException;

/**
 * 게시물 id 에 부합하는 게시물이 없습니다.
 */
public class ArticleNotFoundException extends GlobalException {

    public ArticleNotFoundException() {
    }

    public ArticleNotFoundException(String message, String params) {
        super(message, params);
    }

    public ArticleNotFoundException(String message, Throwable cause, String params) {
        super(message, cause, params);
    }

    public ArticleNotFoundException(Throwable cause, String params) {
        super(cause, params);
    }
}
