package com.example.springboard.common.exception.comment;

import com.example.springboard.common.exception.GlobalException;

/**
 * 댓글 수정에 필요한 비밀번호가 옳바르지 않습니다.
 */
public class CommentModifyWrongPasswordErrorException extends GlobalException {

    public CommentModifyWrongPasswordErrorException() {
    }

    public CommentModifyWrongPasswordErrorException(String message) {
        super(message);
    }

    public CommentModifyWrongPasswordErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommentModifyWrongPasswordErrorException(Throwable cause) {
        super(cause);
    }
}
