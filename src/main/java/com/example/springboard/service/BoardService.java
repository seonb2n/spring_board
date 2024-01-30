package com.example.springboard.service;

import com.example.springboard.common.exception.auth.AuthErrorException;
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

    /**
     * 현재 사용자의 권한으로 게시판에 대한 접근이 가능한지 검증
     *
     * @param board
     * @param isMember
     * @return
     */
    public boolean checkCanReadBoardByAuth(Board board, boolean isMember) {
        // 회원 전용 게시판이고 회원인 경우
        if (board.getBoardAccessAuthority().getAccessLevel()
            .equals(BoardAccessLevel.MEMBER_ONLY.getType()) && isMember) {
            return true;
            // 비회원 전용 게시판이고 비회원인 경우
        } else if (board.getBoardAccessAuthority().getAccessLevel()
            .equals(BoardAccessLevel.NOT_MEMBER_ONLY.getType()) && !isMember) {
            return true;
            // 전체 공게 게시판인 경우
        } else if (board.getBoardAccessAuthority().getAccessLevel()
            .equals(BoardAccessLevel.ALL_BOARD.getType())) {
            return true;
        }
        return false;
    }

    /**
     * 게시판 목록 조회
     *
     * @return
     */
    public List<Board> getBoardList(int page) {
        return boardRepository.findAllWithPaging(page, 20);
    }

    /**
     * boardId 로 게시판 조회
     *
     * @param boardId
     * @return
     */
    public Board getBoardByBoardId(int boardId) {
        return boardRepository.findById(boardId).orElseThrow(
            () -> new FindBoardFailException("해당 ID 를 가진 게시판은 없습니다.", String.valueOf(boardId)));
    }

    /**
     * 게시판 ID 와 멤버 여부로 게시판 내 게시물 목록 조회
     *
     * @param boardId
     * @param isMember
     * @return
     */
    public List<Article> getArticleListByBoardId(int boardId, boolean isMember) {
        Board board = getBoardByBoardId(boardId);
        if (checkCanReadBoardByAuth(board, isMember)) {
            return articleRepository.findArticlesByBoardId(boardId);
        } else {
            throw new AuthErrorException("해당 게시판을 호출할 권한이 없습니다.", String.valueOf(boardId));
        }
    }
}
