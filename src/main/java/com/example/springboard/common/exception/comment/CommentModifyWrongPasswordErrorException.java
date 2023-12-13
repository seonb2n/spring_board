package com.example.springboard.common.exception.comment;

import com.example.springboard.common.exception.BaseInfoException;

public class CommentModifyWrongPasswordErrorException extends BaseInfoException {

    public CommentModifyWrongPasswordErrorException() {
        super("댓글 수정에 필요한 비밀번호가 옳바르지 않습니다.");
    }

}
