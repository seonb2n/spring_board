package com.example.springboard.common.exception.comment;

import com.example.springboard.common.exception.GlobalException;

/**
 * 댓글 생성에 실패했습니다.
 */
public class CommentCreateErrorException extends GlobalException {

    public CommentCreateErrorException() {
    }

    public CommentCreateErrorException(String message) {
        super(message);
    }

    public CommentCreateErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommentCreateErrorException(Throwable cause) {
        super(cause);
    }
}
