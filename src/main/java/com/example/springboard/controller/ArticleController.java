package com.example.springboard.controller;

import com.example.springboard.common.annotations.CheckAuthByToken;
import com.example.springboard.domain.articles.Article;
import com.example.springboard.domain.boards.Board;
import com.example.springboard.dto.request.article.ArticleCreateRequest;
import com.example.springboard.dto.response.CommonResponse;
import com.example.springboard.service.ArticleService;
import com.example.springboard.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Optional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/articles")
public class ArticleController {

    private final BoardService boardService;
    private final ArticleService articleService;

    public ArticleController(BoardService boardService, ArticleService articleService) {
        this.boardService = boardService;
        this.articleService = articleService;
    }

    /**
     * 게시판 내 게시글을 생성한다.
     *
     * @param boardId
     * @param articleCreateRequest
     * @return
     */
    @PostMapping("/create/{board_id}")
    @CheckAuthByToken
    public CommonResponse<Article> createArticle(@PathVariable("board_id") Integer boardId,
        @RequestBody
        ArticleCreateRequest articleCreateRequest,
        HttpServletRequest request
    ) {
        Boolean isMember = (Boolean) request.getAttribute("isMember");
        Optional<Integer> userId = Optional.ofNullable((Integer) request.getAttribute("userId"));
        Board board = boardService.getBoardByBoardId(boardId);
        if (boardService.checkCanReadBoardByAuth(board, isMember)) {
            // 회원인 경우
            if (userId.isPresent()) {
                Article article = articleService.createArticleByMember(articleCreateRequest,
                    userId.get(), boardId);
                return CommonResponse.of("Article Created", article);
            }
            // 비회원인 경우
            else {
                Article article = articleService.createArticleByNoMember(articleCreateRequest,
                    boardId);
                return CommonResponse.of("Article Created", article);
            }
        }
        return CommonResponse.of("Article Created Fail", null);
    }

}
