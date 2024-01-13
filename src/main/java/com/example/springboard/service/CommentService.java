package com.example.springboard.service;

import com.example.springboard.common.exception.comment.CommentNotFoundException;
import com.example.springboard.domain.articles.Comment;
import com.example.springboard.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment getCommentBytCommentId(int commentId) {
        return commentRepository.findCommentByCommentId(commentId).orElseThrow(
            CommentNotFoundException::new);
    }
}
