package com.example.springboard.common.exception.article;

import com.example.springboard.common.exception.GlobalException;

/**
 * 게시물 수정에 필요한 비밀번호가 옳바르지 않습니다.
 */
public class ArticleModifyWrongPasswordErrorException extends GlobalException {

    public ArticleModifyWrongPasswordErrorException() {
    }

    public ArticleModifyWrongPasswordErrorException(String message, String params) {
        super(message, params);
    }

    public ArticleModifyWrongPasswordErrorException(String message, Throwable cause,
        String params) {
        super(message, cause, params);
    }

    public ArticleModifyWrongPasswordErrorException(Throwable cause, String params) {
        super(cause, params);
    }
}
