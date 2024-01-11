package com.example.springboard.mapper;

import com.example.springboard.domain.boards.Board;
import java.util.List;

public interface BoardMapper {

    List<Board> findAll();

    Board findById(Integer id);
}
