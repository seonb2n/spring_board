package com.example.springboard.common.exception.comment;

import com.example.springboard.common.exception.BaseLoggingException;

public class CommentDeleteErrorException extends BaseLoggingException {

    public CommentDeleteErrorException() {
        super("댓글 삭제에 실패했습니다.", LOG_LEVEL.ERROR);
    }

}
