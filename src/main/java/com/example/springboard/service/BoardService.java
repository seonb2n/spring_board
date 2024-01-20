package com.example.springboard.service;

import com.example.springboard.common.exception.board.FindBoardFailException;
import com.example.springboard.domain.articles.Article;
import com.example.springboard.domain.boards.Board;
import com.example.springboard.repository.ArticleRepository;
import com.example.springboard.repository.BoardRepository;
import com.example.springboard.util.enums.BoardAccessLevel;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final ArticleRepository articleRepository;

    public BoardService(BoardRepository boardRepository, ArticleRepository articleRepository) {
        this.boardRepository = boardRepository;
        this.articleRepository = articleRepository;
    }

    public List<Board> getBoardList() {
        return boardRepository.findAll();
    }

    public List<Article> getArticleListByBoardId(int boardId, boolean isMember) {
        Board board = boardRepository.findById(boardId)
            .orElseThrow(
                () -> new FindBoardFailException("해당 ID 를 가진 게시판은 없습니다.", String.valueOf(boardId)));
        if (board.getBoardAccessAuthority().getAccessLevel()
            .equals(BoardAccessLevel.ALL_BOARD.getType())) {
            return articleRepository.findArticlesByBoardId(boardId);
        } else if (board.getBoardAccessAuthority().getAccessLevel()
            .equals(BoardAccessLevel.MEMBER_ONLY.getType()) && isMember) {
            return articleRepository.findArticlesByBoardId(boardId);
        } else if (board.getBoardAccessAuthority().getAccessLevel()
            .equals(BoardAccessLevel.NOT_MEMBER_ONLY.getType()) && !isMember) {
            return articleRepository.findArticlesByBoardId(boardId);
        }
        return List.of();
    }
}
