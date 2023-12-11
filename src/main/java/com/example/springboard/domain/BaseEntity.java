package com.example.springboard.domain;

import java.time.LocalDateTime;

public class BaseEntity {
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    protected BaseEntity() {}
}
