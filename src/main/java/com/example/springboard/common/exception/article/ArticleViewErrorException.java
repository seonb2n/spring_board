package com.example.springboard.common.exception.article;

import com.example.springboard.common.exception.BaseErrorException;

public class ArticleViewErrorException extends BaseErrorException {

    public ArticleViewErrorException() {
        super("게시물 조회에 실패했습니다.");
    }

}
