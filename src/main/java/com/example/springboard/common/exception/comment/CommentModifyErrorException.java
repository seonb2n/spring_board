package com.example.springboard.common.exception.comment;

import com.example.springboard.common.exception.GlobalException;

/**
 * 댓글 수정에 실패했습니다.
 */
public class CommentModifyErrorException extends GlobalException {

    public CommentModifyErrorException() {
    }

    public CommentModifyErrorException(String message, String params) {
        super(message, params);
    }

    public CommentModifyErrorException(String message, Throwable cause, String params) {
        super(message, cause, params);
    }

    public CommentModifyErrorException(Throwable cause, String params) {
        super(cause, params);
    }
}
