package com.example.springboard.common.exception.board;

import com.example.springboard.common.exception.BaseLoggingException;

public class ModifyBoardScopeErrorException extends BaseLoggingException {

    public ModifyBoardScopeErrorException() {
        super("게시판 노출 범위 변경에 실패했습니다.", LOG_LEVEL.ERROR);
    }

}
