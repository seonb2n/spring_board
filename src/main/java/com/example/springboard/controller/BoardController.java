package com.example.springboard.controller;

import com.example.springboard.domain.boards.Board;
import com.example.springboard.dto.response.CommonResponse;
import com.example.springboard.service.BoardService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/boards")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/list")
    CommonResponse<List<Board>> getBoardList() {
        List<Board> boardList = boardService.getBoardList();
        return CommonResponse.of(HttpStatus.OK.getReasonPhrase(), boardList);
    }

}
