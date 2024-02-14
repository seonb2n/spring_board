package com.example.springboard.repository;

import com.example.springboard.domain.articles.Comment;
import com.example.springboard.mapper.CommentMapper;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class CommentRepository {

    private final CommentMapper commentMapper;

    public CommentRepository(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    public Optional<Comment> findCommentByCommentId(int commentId) {
        return Optional.of(commentMapper.findCommentByCommentId(commentId));
    }
}
