package com.example.springboard.dto.response.auth;

public class ValidAuthResponseDto {

    String token;

    public ValidAuthResponseDto(String token) {
        this.token = token;
    }

    public static ValidAuthResponseDto of(String token) {
        return new ValidAuthResponseDto(token);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
