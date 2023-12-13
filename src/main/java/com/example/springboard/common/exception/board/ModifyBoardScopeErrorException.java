package com.example.springboard.common.exception.board;

import com.example.springboard.common.exception.BaseErrorException;

public class ModifyBoardScopeErrorException extends BaseErrorException {

    public ModifyBoardScopeErrorException() {
        super("게시판 노출 범위 변경에 실패했습니다.");
    }

}
