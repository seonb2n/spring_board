package com.example.springboard.util.enums;

public enum BoardAccessLevel {

    ALL_BOARD("ALL"),
    MEMBER_ONLY("MEMBER_ONLY"),
    NOT_MEMBER_ONLY("NOT_MEMBER_ONLY");

    private String type;

    BoardAccessLevel(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
