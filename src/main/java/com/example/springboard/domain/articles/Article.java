package com.example.springboard.domain.articles;

import com.example.springboard.domain.BaseEntity;

public class Article extends BaseEntity {

    private Integer id;
    private Integer userId;
    private Integer boardId;
    private String title;
    private String content;
    private Integer articleCommentNumber;
    private Integer articleHitNumber;

    public Article() {
    }

    /**
     * mybatis 에서 객체를 매핑하기 위해 사용하는 생성자
     *
     * @param id
     * @param userId
     * @param boardId
     * @param title
     * @param content
     * @param articleCommentNumber
     * @param articleHitNumber
     */
    private Article(Integer id, Integer userId, Integer boardId, String title, String content,
        Integer articleCommentNumber, Integer articleHitNumber) {
        this.id = id;
        this.userId = userId;
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.articleCommentNumber = articleCommentNumber;
        this.articleHitNumber = articleHitNumber;
    }

    private Article(Integer userId, Integer boardId, String title, String content,
        Integer articleCommentNumber, Integer articleHitNumber) {
        this.userId = userId;
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.articleCommentNumber = articleCommentNumber;
        this.articleHitNumber = articleHitNumber;
    }

    public static Article of(Integer userId, Integer boardId, String title, String content) {
        return new Article(userId, boardId, title, content, 0, 0);
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getBoardId() {
        return boardId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Integer getArticleCommentNumber() {
        return articleCommentNumber;
    }

    public Integer getArticleHitNumber() {
        return articleHitNumber;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
