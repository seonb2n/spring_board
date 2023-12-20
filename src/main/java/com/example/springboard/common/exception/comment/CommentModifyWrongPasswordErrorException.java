package com.example.springboard.common.exception.comment;

import com.example.springboard.common.exception.GlobalException;

/**
 * 댓글 수정에 필요한 비밀번호가 옳바르지 않습니다.
 */
public class CommentModifyWrongPasswordErrorException extends GlobalException {

    public CommentModifyWrongPasswordErrorException() {
    }

    public CommentModifyWrongPasswordErrorException(String message, String params) {
        super(message, params);
    }

    public CommentModifyWrongPasswordErrorException(String message, Throwable cause,
        String params) {
        super(message, cause, params);
    }

    public CommentModifyWrongPasswordErrorException(Throwable cause, String params) {
        super(cause, params);
    }
}
