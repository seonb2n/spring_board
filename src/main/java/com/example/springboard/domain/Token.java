package com.example.springboard.domain;

import java.time.LocalDateTime;

public class Token {

    private Integer tokenId;
    private Integer userId;
    private String tokenValue;
    private boolean isMember;

    private LocalDateTime createdAt;
    private LocalDateTime expiredAt;

    private Token(Integer userId, String tokenValue, boolean isMember, LocalDateTime createdAt,
        LocalDateTime expiredAt) {
        this.userId = userId;
        this.tokenValue = tokenValue;
        this.isMember = isMember;
        this.createdAt = createdAt;
        this.expiredAt = expiredAt;
    }

    public static Token of(Integer userId, boolean isMember, String tokenValue) {
        return new Token(userId, tokenValue, isMember, LocalDateTime.now(),
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

    public boolean isMember() {
        return isMember;
    }
}
