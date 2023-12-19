package com.example.springboard.common.exception.comment;

import com.example.springboard.common.exception.GlobalException;

/**
 * 댓글 삭제에 실패했습니다.
 */
public class CommentDeleteErrorException extends GlobalException {

    public CommentDeleteErrorException() {
    }

    public CommentDeleteErrorException(String message) {
        super(message);
    }

    public CommentDeleteErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommentDeleteErrorException(Throwable cause) {
        super(cause);
    }
}
