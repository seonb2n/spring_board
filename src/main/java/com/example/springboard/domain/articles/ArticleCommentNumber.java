package com.example.springboard.domain.articles;

import com.example.springboard.domain.BaseEntity;

public class ArticleCommentNumber extends BaseEntity {

    private int id;
    private int commentNumber;

    private ArticleCommentNumber(int id, int commentNumber) {
        this.id = id;
        this.commentNumber = commentNumber;
    }

    static ArticleCommentNumber of(int id) {
        return new ArticleCommentNumber(id, 0);
    }

    public int getId() {
        return id;
    }

    int getCommentNumber() {
        return commentNumber;
    }

    int updateHitHumber() {
        this.commentNumber++;
        return commentNumber;
    }
}
