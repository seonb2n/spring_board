package com.example.springboard.common.exception.comment;

import com.example.springboard.common.exception.BaseErrorException;

public class CommentDeleteErrorException extends BaseErrorException {

    public CommentDeleteErrorException() {
        super("댓글 삭제에 실패했습니다.");
    }

}
