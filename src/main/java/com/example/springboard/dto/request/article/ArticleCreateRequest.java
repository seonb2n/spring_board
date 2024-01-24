package com.example.springboard.dto.request.article;

public class ArticleCreateRequest {

    String title;
    String content;
    String nickName;
    String password;

    public ArticleCreateRequest(String title, String content, String nickName, String password) {
        this.title = title;
        this.content = content;
        this.nickName = nickName;
        this.password = password;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
