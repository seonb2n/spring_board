package com.example.springboard.common.exception.article;

import com.example.springboard.common.exception.BaseErrorException;

public class ArticleDeleteErrorException extends BaseErrorException {

    public ArticleDeleteErrorException() {
        super("게시물 삭제에 실패했습니다.");
    }

}
