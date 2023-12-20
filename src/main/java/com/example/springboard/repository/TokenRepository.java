package com.example.springboard.repository;

import com.example.springboard.domain.Token;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class TokenRepository {

    public Optional<Token> findTokenByValue(String token) {
        return Optional.empty();
    }

    public void saveToken(Token token) {

    }
}
