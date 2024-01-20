package com.example.springboard.common.exception.board;

import com.example.springboard.common.exception.GlobalException;

/**
 * 게시판 조회에 실패했습니다.
 */
public class FindBoardFailException extends GlobalException {

    public FindBoardFailException() {
    }

    public FindBoardFailException(String message, String params) {
        super(message, params);
    }

    public FindBoardFailException(String message, Throwable cause, String params) {
        super(message, cause, params);
    }

    public FindBoardFailException(Throwable cause, String params) {
        super(cause, params);
    }
}
