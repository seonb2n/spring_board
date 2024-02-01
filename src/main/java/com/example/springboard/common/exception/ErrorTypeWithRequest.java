package com.example.springboard.common.exception;

public enum ErrorTypeWithRequest {

    // 로그인
    LOGIN_ID_WRONG(400_001, "아이디가 옳바르지 않습니다."),
    LOGIN_PASSWORD_WRONG(400_002, "비밀번호가 옳바르지 않습니다."),

    // 회원 가입
    SIGNUP_ID_OVERLAPPED(400_005, "ID 가 중복됐습니다."),
    SIGHUP_ALREADY_EXIST_USER(400_006, "이미 가입된 사용자입니다."),
    SIGNUP_EMAIL_FORMAT_WRONG(400_007, "이메일 포맷이 옳바르지 않습니다."),
    SIGNUP_PASSWORD_FORMAT_WRONG(400_008, "비밀번호 형식이 옳바르지 않습니다."),
    SIGNUP_NICKNAME_FORMAT_WRONG(400_009, "닉네임 형식이 옳바르지 않습니다."),
    SIGNUP_NAME_VERIFY_WRONG(400_010, "실명 인증에 실패했습니다."),

    // 회원 관리
    MANAGE_NOT_MEMBER(400_012, "가입된 회원이 아닙니다."),
    MANAGE_MEMBER_DELETE_NO_AUTH(400_014, "회원 탈퇴 권한이 없습니다."),

    // 게시물 목록
    ARTICLE_LIST_VIEW_NO_AUTH(400_015, "게시물 목록을 조회할 권한이 없습니다."),

    // 게시판 관리 권한
    BOARD_MANAGE_NO_AUTH(400_016, "게시판 관리 권한이 없습니다."),

    // 게시물 생성 및 수정
    ARTICLE_CREATE_NO_AUTH(400_017, "해당 게시판에 게시물을 생성할 권한이 없습니다."),
    ARTICLE_CONTENT_WRONG(400_018, "해당 게시물의 내용이 옳바르지 않습니다."),
    ARTICLE_TITLE_WRONG(400_019, "해당 게시물의 제목이 옳바르지 않습니다."),
    ARTICLE_MODIFY_NO_AUTH(400_020, "해당 게시물을 수정할 권한이 없습니다."),
    ARTICLE_VIEW_NO_AUTH(400_021, "해당 게시물을 조회할 권한이 없습니다."),

    // 댓글 생성 및 수정
    COMMENT_CREATE_NO_AUTH(400_022, "해당 게시판에 댓글을 생성할 권한이 없습니다."),
    COMMENT_CONTENT_NO_AUTH(400_023, "해당 댓글의 내용이 옳바르지 않습니다."),
    COMMENT_MODIFY_NO_AUTH(400_024, "해당 댓글을 수정할 권한이 없습니다."),
    COMMENT_CONTENT_WRONG(400_025, "해당 댓글의 내용이 옳바르지 않습니다."),
    COMMENT_VIEW_NO_AUTH(400_026, "해당 게시물의 댓글을 조회할 권한이 없습니다."),

    // 요청에 유효한 ID 혹은 값
    BOARD_NOT_FOUND_BY_ID(400_027, "해당 ID 를 가진 게시판이 존재하지 않습니다."),
    ARTICLE_NOT_FOUND_BY_ID(400_028, "해당 ID 를 가진 게시물이 존재하지 않습니다."),
    COMMENT_NOT_FOUND_BY_ID(400_029, "해당 ID 를 가진 댓글이 존재하지 않습니다."),
    TOKEN_NOT_FOUND_BY_VALUE(400_030, "유효한 토큰이 아닙니다."),
    USER_NOT_FOUND_BY_NICKNAME(400_031, "해당 닉네임을 가진 사용자가 없습니다."),
    USER_NOT_FOUND_BY_ID(400_032, "해당 ID 를 가진 사용자가 없습니다."),

    // 500 에러
    MANAGE_FIND_ID_WRONG(500_002, "아이디 찾기에 실패했습니다."),
    BOARD_LIST_VIEW_FAIL(500_001, "게시판 목록 조회에 실패했습니다."),
    ARTICLE_LIST_VIEW_FAIL(500_003, "게시물 목록 조회에 실패했습니다."),
    COMMENT_LIST_VIEW_FAIL(500_005, "댓글 목록 조회에 실패했습니다."),
    MANAGE_RESET_PASSWORD_FAIL(500_004, "비밀번호 초기화에 실패했습니다.");

    final int code;
    final String message;

    ErrorTypeWithRequest(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
