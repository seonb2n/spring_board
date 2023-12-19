package com.example.springboard.common.exception.board;

import com.example.springboard.common.exception.GlobalException;

/**
 * 게시판 삭제에 실패했습니다.
 */
public class DeleteBoardErrorException extends GlobalException {

    public DeleteBoardErrorException() {
    }

    public DeleteBoardErrorException(String message) {
        super(message);
    }

    public DeleteBoardErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteBoardErrorException(Throwable cause) {
        super(cause);
    }
}
