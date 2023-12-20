package com.example.springboard.common.exception.article;

import com.example.springboard.common.exception.GlobalException;

/**
 * 게시물 조회에 실패했습니다.
 */
public class ArticleViewErrorException extends GlobalException {

    public ArticleViewErrorException() {
    }

    public ArticleViewErrorException(String message, String params) {
        super(message, params);
    }

    public ArticleViewErrorException(String message, Throwable cause, String params) {
        super(message, cause, params);
    }

    public ArticleViewErrorException(Throwable cause, String params) {
        super(cause, params);
    }
}
