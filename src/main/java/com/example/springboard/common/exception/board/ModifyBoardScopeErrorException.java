package com.example.springboard.common.exception.board;

import com.example.springboard.common.exception.GlobalException;

/**
 * 게시판 노출 범위 변경에 실패했습니다.
 */
public class ModifyBoardScopeErrorException extends GlobalException {

    public ModifyBoardScopeErrorException() {
    }

    public ModifyBoardScopeErrorException(String message) {
        super(message);
    }

    public ModifyBoardScopeErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ModifyBoardScopeErrorException(Throwable cause) {
        super(cause);
    }
}
