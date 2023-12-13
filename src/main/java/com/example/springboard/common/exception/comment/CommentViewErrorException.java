package com.example.springboard.common.exception.comment;

import com.example.springboard.common.exception.BaseErrorException;

public class CommentViewErrorException extends BaseErrorException {

    public CommentViewErrorException() {
        super("댓글 조회에 실패했습니다.");
    }

}
