package com.example.springboard.common.exception.board;

import com.example.springboard.common.exception.GlobalException;

/**
 * 게시판 목록을 가져오지 못했습니다.
 */
public class GetListException extends GlobalException {

    public GetListException() {
    }

    public GetListException(String message) {
        super(message);
    }

    public GetListException(String message, Throwable cause) {
        super(message, cause);
    }

    public GetListException(Throwable cause) {
        super(cause);
    }
}
