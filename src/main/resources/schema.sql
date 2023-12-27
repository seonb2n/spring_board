CREATE TABLE token
(
    tokenId    INT AUTO_INCREMENT PRIMARY KEY,
    userId     INT          NOT NULL COMMENT '회원 아이디',
    tokenValue VARCHAR(255) NOT NULL COMMENT '토큰 값',
    createdAt  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '토큰 생성일자',
    expiredAt  TIMESTAMP    NOT NULL COMMENT '토큰 만료일자'
);

CREATE TABLE users
(
    id                 INT AUTO_INCREMENT PRIMARY KEY,
    registered_user_id INT COMMENT '가입 회원 아이디',
    nickname           varchar(255) NOT NULL COMMENT '닉네임',
    password           varchar(255) NOT NULL COMMENT '비회원 비밀번호',
    is_registered      boolean      NOT NULL COMMENT '회원 비회원 여부',
    created_at         TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '회원 생성일자'
);

CREATE TABLE registered_users
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    real_user_id INT          NOT NULL COMMENT '회원 실명 정보',
    account_id   varchar(255) NOT NULL COMMENT '회원 아이디',
    real_name    varchar(255) NOT NULL COMMENT '실명',
    birth_date   varchar(255) NOT NULL COMMENT '생년월일(YYYYMMDD)',
    mobile_no    varchar(255) NOT NULL COMMENT '휴대폰 번호',
    created_at   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '회원 가입일자'
);

CREATE TABLE board_access_authorities
(
    id           INT PRIMARY KEY,
    access_level varchar(255) NOT NULL COMMENT '게시판 접근 권한 종류'
);

CREATE TABLE boards
(
    id                  INT PRIMARY KEY AUTO_INCREMENT,
    title               varchar(255) NOT NULL COMMENT '게시판 제목',
    access_authority_id INT          NOT NULL COMMENT '게시판 접근 권한 아이디'
);

CREATE TABLE articles
(
    id                     INT PRIMARY KEY AUTO_INCREMENT,
    user_id                INT          NOT NULL COMMENT '게시물 작성자 아이디',
    board_id               INT          NOT NULL COMMENT '게시물 소속 게시판 아이디',
    title                  varchar(255) NOT NULL COMMENT '게시물 제목',
    content                text         NOT NULL COMMENT '게시물 내용',
    article_comment_number INT          NOT NULL COMMENT '게시물 댓글 수',
    article_hit_number     INT          NOT NULL COMMENT '게시물 조회 수',
    created_at             TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at             TIMESTAMP    NOT NULL
);

CREATE TABLE comments
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    user_id    INT COMMENT '댓글 작성자 아이디',
    article_id INT          NOT NULL COMMENT '댓글 소속 게시물 아이디',
    content    varchar(255) NOT NULL COMMENT '댓글 내용',
    created_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP    NOT NULL
);