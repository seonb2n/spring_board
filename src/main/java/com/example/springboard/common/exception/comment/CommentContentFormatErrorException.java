package com.example.springboard.common.exception.comment;

import com.example.springboard.common.exception.GlobalException;

/**
 * 댓글 수가 옳바르지 않습니다. 100자 이내
 */
public class CommentContentFormatErrorException extends GlobalException {

    public CommentContentFormatErrorException() {
    }

    public CommentContentFormatErrorException(String message) {
        super(message);
    }

    public CommentContentFormatErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommentContentFormatErrorException(Throwable cause) {
        super(cause);
    }
}
