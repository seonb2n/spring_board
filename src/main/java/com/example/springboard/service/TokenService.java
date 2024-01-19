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

    private String generateToken() {
        return UUID.randomUUID().toString();
    }


    /**
     * userId, member 여부로 토큰을 생성한다.
     *
     * @param userId
     * @param isMember
     * @return
     */
    public String createUserToken(Integer userId, boolean isMember) {
        String tokenValue = generateToken();
        Token createdToken = Token.createUserToken(userId, isMember, tokenValue);
        tokenRepository.saveToken(createdToken);
        return tokenValue;
    }

    /**
     * 사이트에 접속한 사람들에게 발급하는 defaultToken 을 생성한다.
     *
     * @return
     */
    public String createDefaultToken() {
        String tokenValue = generateToken();
        Token createdToken = Token.createDefaultToken(tokenValue);
        tokenRepository.saveToken(createdToken);
        return tokenValue;
    }

    /**
     * 토큰을 검증하고, 사용자 ID 를 가져온다.
     *
     * @param token
     * @return
     */
    public int getUserIdByToken(String token) {
        Token foundToken = tokenRepository.findTokenByValue(token)
            .orElseThrow(() -> new TokenNotFoundException("유효한 토큰이 아닙니다."));
        if (foundToken.getExpiredAt().isBefore(LocalDateTime.now())) {
            throw new TokenExpiredException("유효 기간이 만료된 토큰입니다.");
        }
        return foundToken.getUserId();
    }
}
