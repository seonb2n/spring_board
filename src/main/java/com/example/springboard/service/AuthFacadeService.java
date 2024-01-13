package com.example.springboard.service;

import com.example.springboard.common.exception.GlobalException;
import com.example.springboard.common.exception.user.UserPasswordWrongException;
import com.example.springboard.domain.articles.Article;
import com.example.springboard.domain.articles.Comment;
import com.example.springboard.domain.users.User;
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
            return tokenService.createToken(userId, true);
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
        Article article = articleService.getArticleByArticleId(articleId);
        User user = userService.getUserByUserId(article.getUserId());
        if (user.getNickname().equals(nickname) && user.getPassword().equals(password)) {
            return tokenService.createToken(user.getUserId(), false);
        }
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
        Comment comment = commentService.getCommentBytCommentId(commentId);
        User user = userService.getUserByUserId(comment.getUserId());
        if (user.getNickname().equals(nickname) && user.getPassword().equals(password)) {
            return tokenService.createToken(user.getUserId(), false);
        }
        throw new UserPasswordWrongException();
    }

    /**
     * token 을 바탕으로 User 를 가져온다.
     *
     * @param token
     * @return
     */
    public User getUserByToken(String token) {
        int userId = tokenService.getUserIdByToken(token);
        return userService.getUserByUserId(userId);
    }
}
