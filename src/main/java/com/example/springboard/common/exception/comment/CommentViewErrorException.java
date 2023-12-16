package com.example.springboard.common.exception.comment;

import com.example.springboard.common.exception.BaseLoggingException;

public class CommentViewErrorException extends BaseLoggingException {

    public CommentViewErrorException() {
        super("댓글 조회에 실패했습니다.", LOG_LEVEL.ERROR);
    }

}
