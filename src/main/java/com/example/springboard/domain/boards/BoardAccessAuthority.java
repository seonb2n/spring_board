package com.example.springboard.domain.boards;

import com.example.springboard.util.enums.ACCESSLEVEL;

public class BoardAccessAuthority {

    private int id;
    private ACCESSLEVEL accesslevel;

    private BoardAccessAuthority(int id, ACCESSLEVEL accesslevel) {
        this.id = id;
        this.accesslevel = accesslevel;
    }

    static BoardAccessAuthority of(int id, ACCESSLEVEL accesslevel) {
        return new BoardAccessAuthority(id, accesslevel);
    }

    public int getId() {
        return id;
    }

    public ACCESSLEVEL getAccesslevel() {
        return accesslevel;
    }
}
