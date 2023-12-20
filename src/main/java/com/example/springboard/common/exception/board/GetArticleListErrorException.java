package com.example.springboard.common.exception.board;

import com.example.springboard.common.exception.GlobalException;

/**
 * 게시물 목록을 가져오지 못했습니다.
 */
public class GetArticleListErrorException extends GlobalException {

    public GetArticleListErrorException() {
    }

    public GetArticleListErrorException(String message, String params) {
        super(message, params);
    }

    public GetArticleListErrorException(String message, Throwable cause, String params) {
        super(message, cause, params);
    }

    public GetArticleListErrorException(Throwable cause, String params) {
        super(cause, params);
    }
}
