package com.example.springboard.domain.boards;

import com.example.springboard.util.enums.AccessLevel;

public class BoardAccessAuthority {

    private int id;
    private AccessLevel accesslevel;

    protected BoardAccessAuthority() {
    }

    private BoardAccessAuthority(int id, AccessLevel accesslevel) {
        this.id = id;
        this.accesslevel = accesslevel;
    }

    static BoardAccessAuthority of(int id, AccessLevel accesslevel) {
        return new BoardAccessAuthority(id, accesslevel);
    }

    public int getId() {
        return id;
    }

    public AccessLevel getAccesslevel() {
        return accesslevel;
    }
}
