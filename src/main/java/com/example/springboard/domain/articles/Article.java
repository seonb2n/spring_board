package com.example.springboard.domain.articles;

import com.example.springboard.domain.BaseEntity;
import com.example.springboard.domain.boards.Board;
import com.example.springboard.domain.users.ArticleWriter;

public class Article extends BaseEntity {

    private int id;
    private String title;
    private String content;
    private Board board;
    private ArticleWriter articleWriter;
    private ArticleCommentNumber articleCommentNumber;
    private ArticleHitNumber articleHitNumber;

    private Article(int id, String title, String content, Board board, ArticleWriter articleWriter,
        ArticleCommentNumber articleCommentNumber, ArticleHitNumber articleHitNumber) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.board = board;
        this.articleWriter = articleWriter;
        this.articleCommentNumber = articleCommentNumber;
        this.articleHitNumber = articleHitNumber;
    }

    static Article of(int id, String title, String content, Board board,
        ArticleWriter articleWriter, ArticleCommentNumber articleCommentNumber,
        ArticleHitNumber articleHitNumber) {
        return new Article(id, title, content, board, articleWriter, articleCommentNumber, articleHitNumber);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Board getBoard() {
        return board;
    }

    public ArticleWriter getArticleWriter() {
        return articleWriter;
    }

    public ArticleCommentNumber getArticleCommentNumber() {
        return articleCommentNumber;
    }

    public ArticleHitNumber getArticleHitNumber() {
        return articleHitNumber;
    }
}
