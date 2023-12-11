package com.example.springboard.domain.users;

import com.example.springboard.domain.BaseEntity;

public class UserNoMember extends BaseEntity {

    private int id;
    private String nickName;
    private String password;

    private UserNoMember(int id, String nickName, String password) {
        this.id = id;
        this.nickName = nickName;
        this.password = password;
    }

    static UserNoMember of(int id, String nickName, String password) {
        return new UserNoMember(id, nickName, password);
    }

    public int getId() {
        return id;
    }

    public String getNickName() {
        return nickName;
    }

    public String getPassword() {
        return password;
    }
}
