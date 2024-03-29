package com.example.springboard.controller;

import com.example.springboard.common.annotations.CheckAuthByToken;
import com.example.springboard.common.exception.GlobalException;
import com.example.springboard.domain.articles.Article;
import com.example.springboard.domain.boards.Board;
import com.example.springboard.dto.request.article.ArticleCreateRequest;
import com.example.springboard.dto.request.article.ArticleModifyRequest;
import com.example.springboard.dto.response.CommonResponse;
import com.example.springboard.service.ArticleService;
import com.example.springboard.service.BoardService;
import com.example.springboard.util.enums.ErrorTypeWithRequest;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/articles/{board_id}")
public class ArticleController {

    private final BoardService boardService;
    private final ArticleService articleService;

    public ArticleController(BoardService boardService, ArticleService articleService) {
        this.boardService = boardService;
        this.articleService = articleService;
    }

    @GetMapping("/{article_id}")
    @CheckAuthByToken
    public CommonResponse<Article> getArticle(@PathVariable("board_id") Integer boardId,
        @PathVariable("article_id") Integer articleId,
        HttpServletRequest request
    ) {
        Boolean isMember = (Boolean) request.getAttribute("isMember");
        Board board = boardService.getBoardByBoardId(boardId);
        if (boardService.checkCanReadBoardByAuth(board, isMember)) {
            Article article = articleService.getArticleByArticleId(articleId);
            return CommonResponse.of(HttpStatus.OK, article);
        }
        throw new GlobalException(Map.of("boardId", boardId, "articleId", articleId),
            ErrorTypeWithRequest.ARTICLE_VIEW_NO_AUTH);
    }

    /**
     * 게시판 내 게시글을 생성한다.
     *
     * @param boardId
     * @param articleCreateRequest
     * @return
     */
    @PostMapping("/create")
    @CheckAuthByToken
    public CommonResponse<Article> createArticle(@PathVariable("board_id") Integer boardId,
        @RequestBody
        ArticleCreateRequest articleCreateRequest,
        HttpServletRequest request
    ) {
        Boolean isMember = (Boolean) request.getAttribute("isMember");
        Optional<Integer> userId = Optional.ofNullable((Integer) request.getAttribute("userId"));
        Board board = boardService.getBoardByBoardId(boardId);
        //todo controller 에 로직 제거
        // 권한 및 인증과 관련된 부분은 AuthFacadeService 에 위임해야할 것 같다.
        if (boardService.checkCanReadBoardByAuth(board, isMember)) {
            // 회원인 경우
            if (isMember && userId.isPresent()) {
                Article article = articleService.createArticleByMember(articleCreateRequest,
                    userId.get(), boardId);
                return CommonResponse.of(HttpStatus.CREATED, article);
            }
            // 비회원인 경우
            else if (!isMember) {
                Article article = articleService.createArticleByNoMember(articleCreateRequest,
                    boardId);
                return CommonResponse.of(HttpStatus.CREATED, article);
            }
        }
        throw new GlobalException(Map.of("boardId", boardId, "userId", userId),
            ErrorTypeWithRequest.ARTICLE_CREATE_NO_AUTH);
    }

    @PatchMapping("/modify/{article_id}")
    @CheckAuthByToken
    public CommonResponse<Article> modifyArticle(@PathVariable("board_id") Integer boardId,
        @PathVariable("article_id") Integer articleId,
        @RequestBody ArticleModifyRequest articleModifyRequest, HttpServletRequest request) {
        Boolean isMember = (Boolean) request.getAttribute("isMember");
        //todo controller 에 로직 제거
        // 권한 및 인증과 관련된 부분은 AuthFacadeService 에 위임해야할 것 같다.
        Optional<Integer> userId = Optional.ofNullable((Integer) request.getAttribute("userId"));
        if (userId.isEmpty()) {
            return CommonResponse.of(HttpStatus.BAD_REQUEST, null);
        }
        Board board = boardService.getBoardByBoardId(boardId);
        Article article = articleService.getArticleByArticleId(articleId);

        // 해당 게시판에 대한 접근권한이 있으며, 게시물 작성 당사자인 경우
        if (boardService.checkCanReadBoardByAuth(board, isMember)
            && article.getUserId() == userId.get()) {
            Article updateArticle = articleService.updateArticle(articleId, articleModifyRequest);
            return CommonResponse.of(HttpStatus.OK, updateArticle);
        }
        throw new GlobalException(Map.of("boardId", boardId, "userId", userId),
            ErrorTypeWithRequest.ARTICLE_MODIFY_NO_AUTH);
    }

}
