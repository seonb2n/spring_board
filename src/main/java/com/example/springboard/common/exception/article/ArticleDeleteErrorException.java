package com.example.springboard.common.exception.article;

import com.example.springboard.common.exception.GlobalException;

/**
 * 게시물 삭제에 실패했습니다.
 */
public class ArticleDeleteErrorException extends GlobalException {

    public ArticleDeleteErrorException() {
    }

    public ArticleDeleteErrorException(String message) {
        super(message);
    }

    public ArticleDeleteErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArticleDeleteErrorException(Throwable cause) {
        super(cause);
    }
}
