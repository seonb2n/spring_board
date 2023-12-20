package com.example.springboard.common.exception.board;

import com.example.springboard.common.exception.GlobalException;

/**
 * 게시판 노출 범위 변경에 실패했습니다.
 */
public class ModifyBoardScopeErrorException extends GlobalException {

    public ModifyBoardScopeErrorException() {
    }

    public ModifyBoardScopeErrorException(String message, String params) {
        super(message, params);
    }

    public ModifyBoardScopeErrorException(String message, Throwable cause, String params) {
        super(message, cause, params);
    }

    public ModifyBoardScopeErrorException(Throwable cause, String params) {
        super(cause, params);
    }
}
