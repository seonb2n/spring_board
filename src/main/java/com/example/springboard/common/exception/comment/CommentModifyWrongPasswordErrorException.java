package com.example.springboard.common.exception.comment;

import com.example.springboard.common.exception.BaseLoggingException;

public class CommentModifyWrongPasswordErrorException extends BaseLoggingException {

    public CommentModifyWrongPasswordErrorException() {
        super("댓글 수정에 필요한 비밀번호가 옳바르지 않습니다.", LOG_LEVEL.INFO);
    }

}
