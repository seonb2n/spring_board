package com.example.springboard.common.exception.comment;

import com.example.springboard.common.exception.GlobalException;

/**
 * 댓글 수가 옳바르지 않습니다. 100자 이내
 */
public class CommentContentFormatErrorException extends GlobalException {

    public CommentContentFormatErrorException() {
    }

    public CommentContentFormatErrorException(String message, String params) {
        super(message, params);
    }

    public CommentContentFormatErrorException(String message, Throwable cause, String params) {
        super(message, cause, params);
    }

    public CommentContentFormatErrorException(Throwable cause, String params) {
        super(cause, params);
    }
}
