package com.example.springboard.common.exception.board;

import com.example.springboard.common.exception.GlobalException;

/**
 * 게시판 목록을 가져오지 못했습니다.
 */
public class GetListException extends GlobalException {

    public GetListException() {
    }

    public GetListException(String message, String params) {
        super(message, params);
    }

    public GetListException(String message, Throwable cause, String params) {
        super(message, cause, params);
    }

    public GetListException(Throwable cause, String params) {
        super(cause, params);
    }
}
