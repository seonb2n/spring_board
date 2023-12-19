package com.example.springboard.common.exception.article;

import com.example.springboard.common.exception.GlobalException;

/**
 * 게시물 조회에 실패했습니다.
 */
public class ArticleViewErrorException extends GlobalException {

    public ArticleViewErrorException() {
    }

    public ArticleViewErrorException(String message) {
        super(message);
    }

    public ArticleViewErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArticleViewErrorException(Throwable cause) {
        super(cause);
    }
}
