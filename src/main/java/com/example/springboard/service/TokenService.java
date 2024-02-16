package com.example.springboard.service;

import com.example.springboard.common.exception.GlobalException;
import com.example.springboard.domain.Token;
import com.example.springboard.repository.TokenRepository;
import com.example.springboard.util.enums.ErrorTypeWithRequest;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
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
     * 토큰 VO 가져오기
     *
     * @param token
     * @return
     */
    public Token getTokenByTokenValue(String token) {
        Optional<Token> foundToken = tokenRepository.findTokenByValue(token);
        return foundToken.orElseThrow(() -> new GlobalException(Map.of("token", token),
            ErrorTypeWithRequest.TOKEN_NOT_FOUND_BY_VALUE));
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
        Token foundToken = getTokenByTokenValue(token);
        if (foundToken.getExpiredAt().isBefore(LocalDateTime.now())) {
            throw new GlobalException(Map.of("token", token),
                ErrorTypeWithRequest.TOKEN_NOT_FOUND_BY_VALUE);
        }
        Optional<Integer> userId = Optional.ofNullable(foundToken.getUserId());
        if (userId.isPresent()) {
            return foundToken.getUserId();
        } else {
            //todo 이걸 exception 으로 처리하는게 맞나?
            throw new GlobalException(Map.of(), ErrorTypeWithRequest.DEFAULT_TOKEN);
        }
    }
}
