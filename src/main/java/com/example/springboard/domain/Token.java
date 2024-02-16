package com.example.springboard.domain;

import java.time.LocalDateTime;

public class Token {

    private Integer tokenId;
    private Integer userId;
    private String tokenValue;
    private boolean isMember;
    private boolean isDefault;
    private LocalDateTime createdAt;
    private LocalDateTime expiredAt;

    protected Token() {
    }

    public Token(Integer userId, String tokenValue, boolean isMember, boolean isDefault,
        LocalDateTime createdAt,
        LocalDateTime expiredAt) {
        this.userId = userId;
        this.tokenValue = tokenValue;
        this.isMember = isMember;
        this.isDefault = isDefault;
        this.createdAt = createdAt;
        this.expiredAt = expiredAt;
    }

    public static Token createUserToken(Integer userId, boolean isMember, String tokenValue) {
        return new Token(userId, tokenValue, isMember, false, LocalDateTime.now(),
            LocalDateTime.now().plusDays(7));
    }

    /**
     * @param tokenValue
     * @return
     */
    public static Token createDefaultToken(String tokenValue) {
        return new Token(null, tokenValue, false, true, LocalDateTime.now(),
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
