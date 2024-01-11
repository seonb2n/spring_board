package com.example.springboard.domain.boards;

public class BoardAccessAuthority {

    private int id;
    private String accessLevel;

    public BoardAccessAuthority() {
    }

    public BoardAccessAuthority(int id, String accessLevel) {
        this.id = id;
        this.accessLevel = accessLevel;
    }

    static BoardAccessAuthority of(int id, String accessLevel) {
        return new BoardAccessAuthority(id, accessLevel);
    }

    public int getId() {
        return id;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public void setId(int id) {
        this.id = id;
    }
}
