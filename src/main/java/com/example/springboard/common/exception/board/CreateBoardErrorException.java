package com.example.springboard.common.exception.board;

import com.example.springboard.common.exception.GlobalException;

/**
 * 게시판 생성을 실패했습니다.
 */
public class CreateBoardErrorException extends GlobalException {

    public CreateBoardErrorException() {
    }

    public CreateBoardErrorException(String message, String params) {
        super(message, params);
    }

    public CreateBoardErrorException(String message, Throwable cause, String params) {
        super(message, cause, params);
    }

    public CreateBoardErrorException(Throwable cause, String params) {
        super(cause, params);
    }
}
