package com.example.springboard.controller;

import com.example.springboard.common.annotations.CheckAuthByToken;
import com.example.springboard.domain.articles.Article;
import com.example.springboard.domain.boards.Board;
import com.example.springboard.dto.response.CommonResponse;
import com.example.springboard.service.AuthFacadeService;
import com.example.springboard.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/boards")
public class BoardController {

    private final BoardService boardService;
    private final AuthFacadeService authFacadeService;

    public BoardController(BoardService boardService, AuthFacadeService authFacadeService) {
        this.boardService = boardService;
        this.authFacadeService = authFacadeService;
    }

    /**
     * 게시판 목록 제공
     *
     * @return
     */
    @PostMapping("/list")
    CommonResponse<List<Board>> getBoardList() {
        List<Board> boardList = boardService.getBoardList();
        return CommonResponse.of(HttpStatus.OK.getReasonPhrase(), boardList);
    }

    /**
     * board 에 속한 게시물 리스트 반환 토큰을 확인해서 적절한 권한인 경우만 반환한다.
     *
     * @param boardId
     * @return
     */
    @GetMapping("/{board_id}/articles")
    @CheckAuthByToken
    CommonResponse<List<Article>> getArticlesByBoardId(@PathVariable("board_id") Integer boardId,
        HttpServletRequest request) {
        Boolean isMember = (Boolean) request.getAttribute("isMember");
        List<Article> articleList = boardService.getArticleListByBoardId(boardId, isMember);
        return CommonResponse.of(HttpStatus.OK.getReasonPhrase(), articleList);
    }

}
