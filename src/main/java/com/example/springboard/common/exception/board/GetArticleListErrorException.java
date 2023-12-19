package com.example.springboard.common.exception.board;

import com.example.springboard.common.exception.GlobalException;

/**
 * 게시물 목록을 가져오지 못했습니다.
 */
public class GetArticleListErrorException extends GlobalException {

    public GetArticleListErrorException() {
    }

    public GetArticleListErrorException(String message) {
        super(message);
    }

    public GetArticleListErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public GetArticleListErrorException(Throwable cause) {
        super(cause);
    }
}
