package com.example.springboard.common.exception.article;

import com.example.springboard.common.exception.BaseErrorException;

public class ArticleCreateErrorException extends BaseErrorException {

    public ArticleCreateErrorException() {
        super("게시물 생성에 실패했습니다.");
    }

}
