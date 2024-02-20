package com.example.springboard.dto.response.auth;

public class LoginResponseDto {

    String token;

    public LoginResponseDto() {
    }

    public LoginResponseDto(String token) {
        this.token = token;
    }

    public static LoginResponseDto of(String token) {
        return new LoginResponseDto(token);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
