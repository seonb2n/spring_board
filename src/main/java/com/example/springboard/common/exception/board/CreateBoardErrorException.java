package com.example.springboard.common.exception.board;

import com.example.springboard.common.exception.GlobalException;

/**
 * 게시판 생성을 실패했습니다.
 */
public class CreateBoardErrorException extends GlobalException {

    public CreateBoardErrorException() {
    }

    public CreateBoardErrorException(String message) {
        super(message);
    }

    public CreateBoardErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreateBoardErrorException(Throwable cause) {
        super(cause);
    }
}
