package com.example.springboard.service;

import com.example.springboard.common.exception.GlobalException;
import com.example.springboard.common.exception.user.UserPasswordWrongException;
import com.example.springboard.domain.users.User;
import org.springframework.stereotype.Service;

@Service
public class AuthFacadeService {

    private final UserService userService;
    private final TokenService tokenService;

    public AuthFacadeService(UserService userService, TokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }

    /**
     * 가입된 회원에 대해서, id, password 가 맞으면 토큰을 발급한다.
     *
     * @param accountId
     * @param accountPassword
     * @return
     * @throws GlobalException
     */
    public String authToRegisteredUser(String accountId, String accountPassword)
        throws GlobalException {
        if (userService.isValidUserLogin(accountId, accountPassword)) {
        }
        throw new UserPasswordWrongException();
    }

    /**
     * 비회원에 대해서, articleId, nickname, password 가 맞으면 토큰을 발급한다.
     *
     * @param nickname
     * @param password
     * @return
     * @throws GlobalException
     */
    public String authToUnregisteredUserForArticle(int articleId, String nickname, String password)
        throws GlobalException {
        throw new UserPasswordWrongException();
    }

    /**
     * 비회원에 대해서, commentId, nickname, password 가 맞으면 토큰을 발급한다.
     *
     * @param nickname
     * @param password
     * @return
     * @throws GlobalException
     */
    public String authToUnregisteredUserForComment(int commentId, String nickname, String password)
        throws GlobalException {
        throw new UserPasswordWrongException();
    }

    /**
     * token 을 바탕으로 User 를 가져온다.
     *
     * @param token
     * @return
     */
    public User getUserByToken(String token) {
        return null;
    }
}
