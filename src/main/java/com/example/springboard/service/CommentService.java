package com.example.springboard.service;

import com.example.springboard.common.exception.GlobalException;
import com.example.springboard.domain.articles.Comment;
import com.example.springboard.repository.CommentRepository;
import com.example.springboard.util.enums.ErrorTypeWithRequest;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment getCommentBytCommentId(int commentId) {
        return commentRepository.findCommentByCommentId(commentId)
            .orElseThrow(() -> new GlobalException(
                Map.of("commentId", commentId),
                ErrorTypeWithRequest.COMMENT_NOT_FOUND_BY_ID));
    }
}
