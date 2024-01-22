DROP table if exists tokens;
DROP table if exists users;
DROP table if exists registered_users;
DROP table if exists board_access_authorities;
DROP table if exists boards;
DROP table if exists articles;
DROP table if exists comments;


CREATE TABLE tokens
(
    token_id    INT AUTO_INCREMENT PRIMARY KEY,
    user_id     INT          NOT NULL COMMENT '회원 아이디',
    token_value VARCHAR(255) NOT NULL COMMENT '토큰 값',
    is_member boolean NOT NULL COMMENT '토큰 소유자 회원 여부',
    is_default boolean NOT NULL COMMENT '기본 토큰 여부',
    created_at  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '토큰 생성일자',
    expired_at  TIMESTAMP    NOT NULL COMMENT '토큰 만료일자'
);

CREATE TABLE users
(
    id                 INT AUTO_INCREMENT PRIMARY KEY,
    nickname           varchar(255) NOT NULL COMMENT '닉네임',
    is_registered      boolean      NOT NULL COMMENT '회원 비회원 여부',
    registered_user_id INT COMMENT '가입 회원 아이디',
    password           varchar(255) COMMENT '비회원 비밀번호',
    created_at         TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '회원 생성일자'
);

CREATE TABLE registered_users
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    account_id   varchar(255) NOT NULL COMMENT '회원 아이디',
    account_password varchar(255) NOT NULL COMMENT '회원 비밀번호',
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
    content varchar(4095) COMMENT '게시물 내용',
    article_comment_number INT          NOT NULL COMMENT '게시물 댓글 수',
    article_hit_number     INT          NOT NULL COMMENT '게시물 조회 수',
    created_at             TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE comments
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    user_id    INT COMMENT '댓글 작성자 아이디',
    article_id INT          NOT NULL COMMENT '댓글 소속 게시물 아이디',
    content    varchar(255) NOT NULL COMMENT '댓글 내용',
    created_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

INSERT INTO board.users
(registered_user_id, nickname, password, is_registered, created_at)
VALUES (null, 'test01', '1234', 0, CURRENT_TIMESTAMP);

INSERT INTO board.users
(registered_user_id, nickname, password, is_registered, created_at)
VALUES (1, 'test01', '1234', 1, CURRENT_TIMESTAMP);

INSERT INTO board.registered_users
(id, account_id, account_password, real_name, birth_date, mobile_no, created_at)
VALUES (1, 'test01_id', 'test01_password', '김테스트', '001228', '010-1234-5678', CURRENT_TIMESTAMP);

INSERT INTO board.boards
    (id, title, access_authority_id)
VALUES (1, 'all_board', 1);

INSERT INTO board.boards
    (id, title, access_authority_id)
VALUES (2, 'member_board', 2);

INSERT INTO board.boards
    (id, title, access_authority_id)
VALUES (3, 'not_member_board', 3);

INSERT INTO board.board_access_authorities
    (id, access_level)
VALUES (1, 'ALL');

INSERT INTO board.board_access_authorities
    (id, access_level)
VALUES (2, 'MEMBER_ONLY');

INSERT INTO board.board_access_authorities
    (id, access_level)
VALUES (3, 'NOT_MEMBER_ONLY');

INSERT INTO board.articles
(user_id, board_id, title, content, article_comment_number, article_hit_number)
VALUES (1, 1, 'written_no_member', 'I am not a member', 0, 0);

INSERT INTO board.articles
(user_id, board_id, title, content, article_comment_number, article_hit_number)
VALUES (2, 1, 'written_member', 'I am a member', 0, 0);

INSERT INTO board.articles
(user_id, board_id, title, content, article_comment_number, article_hit_number)
VALUES (2, 2, 'written_member', 'I am a member and this is member board', 0, 0);

INSERT INTO board.comments
    (user_id, article_id, content)
VALUES (1, 0, 'I am not a member too');

INSERT INTO board.comments
    (user_id, article_id, content)
VALUES (2, 0, 'but I am a member');

INSERT into board.tokens
(token_id, user_id, token_value, is_member, is_default, created_at, expired_at)
values (1, 1, '54fa233d-6331-44dd-9a87-ce06db48945d', 1, 0, now(), DATE_ADD(NOW(), INTERVAL 3 DAY));
