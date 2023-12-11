package com.example.springboard.domain.users;

import com.example.springboard.domain.BaseEntity;

public class ArticleWriter extends BaseEntity {

    public int id;
    private boolean isMemeber;
    private User user;
    private UserNoMember userNoMember;

    private ArticleWriter(int id, boolean isMemeber, User user, UserNoMember userNoMember) {
        this.id = id;
        this.isMemeber = isMemeber;
        this.user = user;
        this.userNoMember = userNoMember;
    }

    static ArticleWriter of(int id, boolean isMemeber, User user, UserNoMember userNoMember) {
        return new ArticleWriter(id, isMemeber, user, userNoMember);
    }

    public int getId() {
        return id;
    }

    public boolean isMemeber() {
        return isMemeber;
    }

    public User getUser() {
        return user;
    }

    public UserNoMember getUserNoMember() {
        return userNoMember;
    }
}
