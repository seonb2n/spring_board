package com.example.springboard.common.exception.comment;

import com.example.springboard.common.exception.GlobalException;

/**
 * 댓글 삭제에 실패했습니다.
 */
public class CommentDeleteErrorException extends GlobalException {

    public CommentDeleteErrorException() {
    }

    public CommentDeleteErrorException(String message, String params) {
        super(message, params);
    }

    public CommentDeleteErrorException(String message, Throwable cause, String params) {
        super(message, cause, params);
    }

    public CommentDeleteErrorException(Throwable cause, String params) {
        super(cause, params);
    }
}
