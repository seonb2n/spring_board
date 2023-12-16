package com.example.springboard.common.exception.comment;

import com.example.springboard.common.exception.BaseLoggingException;

public class CommentCreateErrorException extends BaseLoggingException {

    public CommentCreateErrorException() {
        super("댓글 생성에 실패했습니다.", LOG_LEVEL.ERROR);
    }

}
