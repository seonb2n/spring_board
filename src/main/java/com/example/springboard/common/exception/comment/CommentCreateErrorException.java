package com.example.springboard.common.exception.comment;

import com.example.springboard.common.exception.BaseErrorException;

public class CommentCreateErrorException extends BaseErrorException {

    public CommentCreateErrorException() {
        super("댓글 생성에 실패했습니다.");
    }

}
