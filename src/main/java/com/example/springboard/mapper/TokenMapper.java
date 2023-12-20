package com.example.springboard.mapper;

import com.example.springboard.domain.Token;

public interface TokenMapper {

    void insertToken(Token token);

    Token findTokenByValue(String tokenValue);

}
