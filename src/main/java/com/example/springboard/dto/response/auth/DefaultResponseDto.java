package com.example.springboard.dto.response.auth;

public class DefaultResponseDto {

    String token;

    public DefaultResponseDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
