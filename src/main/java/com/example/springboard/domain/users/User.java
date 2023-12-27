package com.example.springboard.domain.users;

import com.example.springboard.domain.BaseEntity;

public class User extends BaseEntity {

    private Integer id;
    private Integer userId;
    private String nickname;
    private String password;
    private Boolean isRegistered;

    private User(Integer userId, String nickname, String password, Boolean isRegistered) {
        this.userId = userId;
        this.nickname = nickname;
        this.password = password;
        this.isRegistered = isRegistered;
    }

    public static User of(Integer userId, String nickname, String password, Boolean isRegistered) {
        return new User(userId, nickname, password, isRegistered);
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getRegistered() {
        return isRegistered;
    }
}
