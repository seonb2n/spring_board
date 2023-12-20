package com.example.springboard.common.exception.comment;

import com.example.springboard.common.exception.GlobalException;

/**
 * 댓글 조회에 실패했습니다.
 */
public class CommentViewErrorException extends GlobalException {

    public CommentViewErrorException() {
    }

    public CommentViewErrorException(String message, String params) {
        super(message, params);
    }

    public CommentViewErrorException(String message, Throwable cause, String params) {
        super(message, cause, params);
    }

    public CommentViewErrorException(Throwable cause, String params) {
        super(cause, params);
    }
}
