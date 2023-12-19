package com.example.springboard.common.exception.article;

import com.example.springboard.common.exception.GlobalException;

/**
 * 게시물 삭제에 필요한 비밀번호가 옳바르지 않습니다.
 */
public class ArticleDeleteWrongPasswordErrorException extends GlobalException {

    public ArticleDeleteWrongPasswordErrorException() {
    }

    public ArticleDeleteWrongPasswordErrorException(String message) {
        super(message);
    }

    public ArticleDeleteWrongPasswordErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArticleDeleteWrongPasswordErrorException(Throwable cause) {
        super(cause);
    }
}
