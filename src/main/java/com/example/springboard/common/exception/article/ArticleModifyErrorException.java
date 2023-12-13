package com.example.springboard.common.exception.article;

import com.example.springboard.common.exception.BaseErrorException;

public class ArticleModifyErrorException extends BaseErrorException {

    public ArticleModifyErrorException() {
        super("게시물 수정에 실패했습니다.");
    }

}
