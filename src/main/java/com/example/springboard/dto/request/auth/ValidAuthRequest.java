package com.example.springboard.dto.request.auth;

public class ValidAuthRequest {

    int targetId;
    String nickname;
    String password;

    public ValidAuthRequest(int targetId, String nickname, String password) {
        this.targetId = targetId;
        this.nickname = nickname;
        this.password = password;
    }

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
