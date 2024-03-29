package com.example.springboard.service;

import com.example.springboard.common.exception.GlobalException;
import com.example.springboard.domain.Token;
import com.example.springboard.domain.articles.Article;
import com.example.springboard.domain.articles.Comment;
import com.example.springboard.domain.users.User;
import com.example.springboard.util.enums.ErrorTypeWithRequest;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class AuthFacadeService {

    private final UserService userService;
    private final TokenService tokenService;
    private final ArticleService articleService;
    private final CommentService commentService;

    public AuthFacadeService(UserService userService, TokenService tokenService,
        ArticleService articleService, CommentService commentService) {
        this.userService = userService;
        this.tokenService = tokenService;
        this.articleService = articleService;
        this.commentService = commentService;
    }

    /**
     * 최초 접속 시 default Token 을 발급함
     *
     * @return
     */
    public String getDefaultToken() {
        return tokenService.createDefaultToken();
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
            int userId = userService.getUserIdByAccountId(accountId);
            return tokenService.createUserToken(userId, true);
        }
        throw new GlobalException(
            Map.of("accountId", accountId, "accountPassword", accountPassword),
            ErrorTypeWithRequest.LOGIN_PASSWORD_WRONG);
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
        Article article = articleService.getArticleByArticleId(articleId);
        User user = userService.getUserBytUserId(article.getUserId());
        if (user.getNickname().equals(nickname) && user.getPassword().equals(password)) {
            return tokenService.createUserToken(user.getRegisteredUserId(), false);
        }
        throw new GlobalException(
            Map.of("articleId", articleId, "nickname", nickname, "password", password),
            ErrorTypeWithRequest.ARTICLE_MODIFY_NO_AUTH);
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
        Comment comment = commentService.getCommentBytCommentId(commentId);
        User user = userService.getUserBytUserId(comment.getUserId());
        if (user.getNickname().equals(nickname) && user.getPassword().equals(password)) {
            return tokenService.createUserToken(user.getRegisteredUserId(), false);
        }
        throw new GlobalException(
            Map.of("commentId", commentId, "nickname", nickname, "password", password),
            ErrorTypeWithRequest.COMMENT_MODIFY_NO_AUTH);
    }

    /**
     * 전달된 토큰을 통해서 회원인지 비회원인지 확인한다.
     *
     * @param token
     * @return
     */
    public boolean isTokenOwnedByMember(String token) {
        try {
            Token foundToken = tokenService.getTokenByTokenValue(token);
            return foundToken.isMember();
        } catch (GlobalException e) {
            return false;
        }
    }

    /**
     * token 을 바탕으로 User 를 가져온다.
     *
     * @param token
     * @return
     */
    public User getUserByToken(String token) {
        int userId = tokenService.getUserIdByToken(token);
        return userService.getUserBytUserId(userId);
    }

    /**
     * 주어진 token 으로 해당 article 에 대한 수정 권한이 있는지 확인한다.
     *
     * @param token
     * @param articleId
     * @return
     */
    public boolean authToArticleByToken(String token, int articleId) {
        int userIdFromToken = tokenService.getUserIdByToken(token);
        int userIdFromArticle = articleService.getArticleByArticleId(articleId).getUserId();
        return userIdFromToken == userIdFromArticle;
    }

    /**
     * 주어진 token 으로 해당 comment 에 대한 수정 권한이 있는지 확인한다.
     *
     * @param token
     * @param commentId
     * @return
     */
    public boolean authToCommentByToken(String token, int commentId) {
        int userIdFromToken = tokenService.getUserIdByToken(token);
        int userIdFromComment = commentService.getCommentBytCommentId(commentId).getUserId();
        return userIdFromToken == userIdFromComment;
    }
}
