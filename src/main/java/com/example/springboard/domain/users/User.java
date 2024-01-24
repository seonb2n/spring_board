package com.example.springboard.domain.users;

import com.example.springboard.domain.BaseEntity;

public class User extends BaseEntity {

    private Integer id;
    private String nickname;
    private String password;
    private Boolean isRegistered;

    private Integer registeredUserId;

    private User(Integer id, String nickname, String password, Boolean isRegistered,
        Integer registeredUserId) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.isRegistered = isRegistered;
        this.registeredUserId = registeredUserId;
    }

    private User(Integer registeredUserId, String nickname, String password, Boolean isRegistered) {
        this.registeredUserId = registeredUserId;
        this.nickname = nickname;
        this.password = password;
        this.isRegistered = isRegistered;
    }

    private User(String nickname, String password, Boolean isRegistered) {
        this.nickname = nickname;
        this.password = password;
        this.isRegistered = isRegistered;
    }

    public static User of(Integer userId, String nickname, String password, Boolean isRegistered) {
        return new User(userId, nickname, password, isRegistered);
    }

    public static User of(String nickname, String password, Boolean isRegistered) {
        return new User(nickname, password, isRegistered);
    }

    public Integer getId() {
        return id;
    }

    public Integer getRegisteredUserId() {
        return registeredUserId;
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
