package com.example.springboard.domain.articles;

import com.example.springboard.domain.BaseEntity;

public class ArticleHitNumber extends BaseEntity {

    private int id;
    private int hitNumber;

    private ArticleHitNumber(int id, int hitNumber) {
        this.id = id;
        this.hitNumber = hitNumber;
    }

    static ArticleHitNumber of(int id) {
        return new ArticleHitNumber(id, 0);
    }

    public int getId() {
        return id;
    }

    int getHitNumber() {
        return hitNumber;
    }

    int updateHitHumber() {
        this.hitNumber++;
        return hitNumber;
    }
}
