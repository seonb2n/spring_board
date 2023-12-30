package com.example.springboard.common.exception.comment;

import com.example.springboard.common.exception.GlobalException;

/**
 * 댓글 생성에 실패했습니다.
 */
public class CommentCreateErrorException extends GlobalException {

    public CommentCreateErrorException() {
    }

    public CommentCreateErrorException(String message, String params) {
        super(message, params);
    }

    public CommentCreateErrorException(String message, Throwable cause, String params) {
        super(message, cause, params);
    }

    public CommentCreateErrorException(Throwable cause, String params) {
        super(cause, params);
    }
}
