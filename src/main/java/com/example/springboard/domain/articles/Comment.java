package com.example.springboard.domain.articles;

import com.example.springboard.domain.BaseEntity;
import com.example.springboard.domain.users.ArticleWriter;

public class Comment extends BaseEntity {

    private int id;
    private String content;
    private ArticleWriter articleWriter;

    private Comment(int id, String content, ArticleWriter articleWriter) {
        this.id = id;
        this.content = content;
        this.articleWriter = articleWriter;
    }

    static Comment of(int id, String content, ArticleWriter articleWriter) {
        return new Comment(id, content, articleWriter);
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public ArticleWriter getArticleWriter() {
        return articleWriter;
    }
}
