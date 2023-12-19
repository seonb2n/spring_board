package com.example.springboard.common.exception.article;

import com.example.springboard.common.exception.GlobalException;

/**
 * 게시물 수정에 필요한 비밀번호가 옳바르지 않습니다.
 */
public class ArticleModifyWrongPasswordErrorException extends GlobalException {

    public ArticleModifyWrongPasswordErrorException() {
    }

    public ArticleModifyWrongPasswordErrorException(String message) {
        super(message);
    }

    public ArticleModifyWrongPasswordErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArticleModifyWrongPasswordErrorException(Throwable cause) {
        super(cause);
    }
}
