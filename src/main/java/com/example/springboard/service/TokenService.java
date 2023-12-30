package com.example.springboard.service;

import com.example.springboard.common.exception.token.TokenExpiredException;
import com.example.springboard.common.exception.token.TokenNotFoundException;
import com.example.springboard.domain.Token;
import com.example.springboard.repository.TokenRepository;
import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private final TokenRepository tokenRepository;

    public TokenService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    public String createToken(Integer userId) {
        String tokenValue = UUID.randomUUID().toString();
        Token createdToken = Token.of(userId, tokenValue);
        tokenRepository.saveToken(createdToken);
        return tokenValue;
    }

    public boolean validateToken(String token) {
        Token foundToken = tokenRepository.findTokenByValue(token)
            .orElseThrow(() -> new TokenNotFoundException("유효한 토큰이 아닙니다."));
        if (foundToken.getExpiredAt().isBefore(LocalDateTime.now())) {
            throw new TokenExpiredException("유효 기간이 만료된 토큰입니다.");
        }
        return true;
    }

}
