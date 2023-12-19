package com.example.springboard.common.exception.comment;

import com.example.springboard.common.exception.GlobalException;

/**
 * 댓글 조회에 실패했습니다.
 */
public class CommentViewErrorException extends GlobalException {

    public CommentViewErrorException() {
    }

    public CommentViewErrorException(String message) {
        super(message);
    }

    public CommentViewErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommentViewErrorException(Throwable cause) {
        super(cause);
    }
}
