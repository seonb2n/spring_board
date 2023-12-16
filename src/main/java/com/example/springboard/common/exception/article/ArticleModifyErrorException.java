package com.example.springboard.common.exception.article;

import com.example.springboard.common.exception.BaseLoggingException;

public class ArticleModifyErrorException extends BaseLoggingException {

    public ArticleModifyErrorException() {
        super("게시물 수정에 실패했습니다.", LOG_LEVEL.ERROR);
    }

}
