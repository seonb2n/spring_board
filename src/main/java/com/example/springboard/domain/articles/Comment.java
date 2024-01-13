package com.example.springboard.domain.articles;

import com.example.springboard.domain.BaseEntity;

public class Comment extends BaseEntity {

    private Integer id;
    private Integer userId;
    private Integer articleId;
    private String content;

    public Comment(Integer userId, Integer articleId, String content) {
        this.userId = userId;
        this.articleId = articleId;
        this.content = content;
    }

    public static Comment of(Integer userId, Integer articleId, String content) {
        return new Comment(userId, articleId, content);
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public String getContent() {
        return content;
    }
}
