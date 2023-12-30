package com.example.springboard.common.exception.article;

import com.example.springboard.common.exception.GlobalException;

/**
 * 게시물 삭제에 실패했습니다.
 */
public class ArticleDeleteErrorException extends GlobalException {

    public ArticleDeleteErrorException() {
    }

    public ArticleDeleteErrorException(String message, String params) {
        super(message, params);
    }

    public ArticleDeleteErrorException(String message, Throwable cause, String params) {
        super(message, cause, params);
    }

    public ArticleDeleteErrorException(Throwable cause, String params) {
        super(cause, params);
    }
}
