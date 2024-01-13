package com.example.springboard.common.exception.comment;

import com.example.springboard.common.exception.GlobalException;

/**
 * 댓글 id 에 부합하는 댓글이 없습니다.
 */
public class CommentNotFoundException extends GlobalException {

    public CommentNotFoundException() {
    }

    public CommentNotFoundException(String message, String params) {
        super(message, params);
    }

    public CommentNotFoundException(String message, Throwable cause, String params) {
        super(message, cause, params);
    }

    public CommentNotFoundException(Throwable cause, String params) {
        super(cause, params);
    }
}
