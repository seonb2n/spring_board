package com.example.springboard.dto.request.auth;

public class LoginRequest {

    String userId;
    String password;

    public LoginRequest() {
    }

    ;

    public LoginRequest(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
