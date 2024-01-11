package com.example.springboard.domain.boards;

import com.example.springboard.domain.BaseEntity;

public class Board extends BaseEntity {

    private int id;
    private String title;
    private BoardAccessAuthority boardAccessAuthority;

    public Board() {
    }

    public Board(int id, String title, BoardAccessAuthority boardAccessAuthority) {
        this.id = id;
        this.title = title;
        this.boardAccessAuthority = boardAccessAuthority;
    }

    static Board of(int id, String title, BoardAccessAuthority boardAccessAuthority) {
        return new Board(id, title, boardAccessAuthority);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public BoardAccessAuthority getBoardAccessAuthority() {
        return boardAccessAuthority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBoardAccessAuthority(
        BoardAccessAuthority boardAccessAuthority) {
        this.boardAccessAuthority = boardAccessAuthority;
    }
}
