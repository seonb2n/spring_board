package com.example.springboard.mapper;

import com.example.springboard.domain.boards.Board;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BoardMapper {

    List<Board> findAllWithPaging(@Param("offset") int offset, @Param("limit") int limit);

    Board findById(Integer id);
}
