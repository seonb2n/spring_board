package com.example.springboard.common.exception.comment;

import com.example.springboard.common.exception.BaseInfoException;

public class CommentContentFormatErrorException extends BaseInfoException {

    public CommentContentFormatErrorException() {
        super("댓글 수가 옳바르지 않습니다. 100자 이내");
    }

}
