package com.example.springboard.service;

import com.example.springboard.domain.boards.Board;
import com.example.springboard.repository.BoardRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<Board> getBoardList() {
        return boardRepository.findAll();

    }
}
