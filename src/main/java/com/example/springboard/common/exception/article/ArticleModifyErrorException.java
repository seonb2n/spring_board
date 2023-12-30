package com.example.springboard.common.exception.article;

import com.example.springboard.common.exception.GlobalException;

/**
 * 게시물 수정에 실패했습니다.
 */
public class ArticleModifyErrorException extends GlobalException {

    public ArticleModifyErrorException() {
    }

    public ArticleModifyErrorException(String message, String params) {
        super(message, params);
    }

    public ArticleModifyErrorException(String message, Throwable cause, String params) {
        super(message, cause, params);
    }

    public ArticleModifyErrorException(Throwable cause, String params) {
        super(cause, params);
    }
}
