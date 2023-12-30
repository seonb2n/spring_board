package com.example.springboard.common.exception.board;

import com.example.springboard.common.exception.GlobalException;

/**
 * 게시판 삭제에 실패했습니다.
 */
public class DeleteBoardErrorException extends GlobalException {

    public DeleteBoardErrorException() {
    }

    public DeleteBoardErrorException(String message, String params) {
        super(message, params);
    }

    public DeleteBoardErrorException(String message, Throwable cause, String params) {
        super(message, cause, params);
    }

    public DeleteBoardErrorException(Throwable cause, String params) {
        super(cause, params);
    }
}
