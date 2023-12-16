package com.example.springboard.common.exception.comment;

import com.example.springboard.common.exception.BaseLoggingException;

public class CommentContentFormatErrorException extends BaseLoggingException {

    public CommentContentFormatErrorException() {
        super("댓글 수가 옳바르지 않습니다. 100자 이내", LOG_LEVEL.INFO);
    }

}
