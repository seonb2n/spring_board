package com.example.springboard.common.exception.article;

import com.example.springboard.common.exception.GlobalException;

/**
 * 게시물 수정에 실패했습니다.
 */
public class ArticleModifyErrorException extends GlobalException {

    public ArticleModifyErrorException() {
    }

    public ArticleModifyErrorException(String message) {
        super(message);
    }

    public ArticleModifyErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArticleModifyErrorException(Throwable cause) {
        super(cause);
    }
}
