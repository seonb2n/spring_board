package com.example.springboard.domain.users;

import com.example.springboard.domain.BaseEntity;

public class CommentWriter extends BaseEntity {
    private int id;
    private boolean isMember;
    private User user;
    private UserNoMember userNoMember;

    private CommentWriter(int id, boolean isMember, User user, UserNoMember userNoMember) {
        this.id = id;
        this.isMember = isMember;
        this.user = user;
        this.userNoMember = userNoMember;
    }

    static CommentWriter of(int id, boolean isMember, User user, UserNoMember userNoMember) {
        return new CommentWriter(id, isMember, user, userNoMember);
    }

    public int getId() {
        return id;
    }

    public boolean isMember() {
        return isMember;
    }

    public User getUser() {
        return user;
    }

    public UserNoMember getUserNoMember() {
        return userNoMember;
    }
}
