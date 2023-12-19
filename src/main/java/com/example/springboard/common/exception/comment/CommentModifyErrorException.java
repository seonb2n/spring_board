package com.example.springboard.common.exception.comment;

import com.example.springboard.common.exception.GlobalException;

/**
 * 댓글 수정에 실패했습니다.
 */
public class CommentModifyErrorException extends GlobalException {

    public CommentModifyErrorException() {
    }

    public CommentModifyErrorException(String message) {
        super(message);
    }

    public CommentModifyErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommentModifyErrorException(Throwable cause) {
        super(cause);
    }
}
