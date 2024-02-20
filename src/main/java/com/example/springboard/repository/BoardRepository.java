package com.example.springboard.repository;

import com.example.springboard.domain.boards.Board;
import com.example.springboard.mapper.BoardMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class BoardRepository {

    private final BoardMapper boardMapper;

    public BoardRepository(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    public List<Board> findAllWithPaging(int page, int pageNumber) {
        if (page < 1) {
            page = 1;
        }
        int offset = (page - 1) * pageNumber;
        return boardMapper.findAllWithPaging(offset, pageNumber);
    }

    public Optional<Board> findById(Integer id) {
        return Optional.ofNullable(boardMapper.findById(id));
    }
}
