package com.example.springboard.common.exception.comment;

import com.example.springboard.common.exception.BaseLoggingException;

public class CommentModifyErrorException extends BaseLoggingException {

    public CommentModifyErrorException() {
        super("댓글 수정에 실패했습니다.", LOG_LEVEL.ERROR);
    }

}
