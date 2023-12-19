package com.example.springboard.common.exception.article;

import com.example.springboard.common.exception.GlobalException;

/**
 * 게시물 생성에 실패했습니다.
 */
public class ArticleCreateErrorException extends GlobalException {

    public ArticleCreateErrorException() {
    }

    public ArticleCreateErrorException(String message) {
        super(message);
    }

    public ArticleCreateErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArticleCreateErrorException(Throwable cause) {
        super(cause);
    }
}
