package com.example.springboard.common.exception.comment;

import com.example.springboard.common.exception.BaseErrorException;

public class CommentModifyErrorException extends BaseErrorException {

    public CommentModifyErrorException() {
        super("댓글 수정에 실패했습니다.");
    }

}
