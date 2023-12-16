package com.example.springboard.common.exception.article;

import com.example.springboard.common.exception.BaseLoggingException;

public class ArticleDeleteWrongPasswordErrorException extends BaseLoggingException {

    public ArticleDeleteWrongPasswordErrorException() {
        super("게시물 삭제에 필요한 비밀번호가 옳바르지 않습니다.", LOG_LEVEL.INFO);
    }

}
