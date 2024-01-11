package com.example.springboard.domain;

import java.time.LocalDateTime;

public class BaseEntity {
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    protected BaseEntity() {}

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
