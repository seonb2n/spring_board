package com.example.springboard.common.exception.article;

import com.example.springboard.common.exception.BaseInfoException;

public class ArticleModifyWrongPasswordErrorException extends BaseInfoException {

    public ArticleModifyWrongPasswordErrorException() {
        super("게시물 수정에 필요한 비밀번호가 옳바르지 않습니다.");
    }

}
