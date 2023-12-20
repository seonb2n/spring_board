package com.example.springboard.domain;

import java.time.LocalDateTime;

public class Token {

    Integer tokenId;
    Integer userId;
    String tokenValue;
    LocalDateTime createdAt;
    LocalDateTime expiredAt;

    private Token(Integer tokenId, Integer userId, String tokenValue, LocalDateTime createdAt,
        LocalDateTime expiredAt) {
        this.tokenId = tokenId;
        this.userId = userId;
        this.tokenValue = tokenValue;
        this.createdAt = createdAt;
        this.expiredAt = expiredAt;
    }

    public static Token of(Integer tokenId, Integer userId, String tokenValue) {
        return new Token(tokenId, userId, tokenValue, LocalDateTime.now(),
            LocalDateTime.now().plusDays(7));
    }

    public Integer getTokenId() {
        return tokenId;
    }

    public Integer getUserId() {
        return userId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getExpiredAt() {
        return expiredAt;
    }
}
