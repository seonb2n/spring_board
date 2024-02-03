package com.example.springboard.repository;

import com.example.springboard.domain.Token;
import com.example.springboard.mapper.TokenMapper;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class TokenRepository {

    private final TokenMapper tokenMapper;

    public TokenRepository(TokenMapper tokenMapper) {
        this.tokenMapper = tokenMapper;
    }

    public Optional<Token> findTokenByValue(String token) {
        return Optional.ofNullable(tokenMapper.findTokenByValue(token));
    }

    public void saveToken(Token token) {
        tokenMapper.insertToken(token);
    }
}
