package com.example.springboard.mapper;

import com.example.springboard.domain.articles.Comment;

public interface CommentMapper {

    Comment findCommentByCommentId(Integer commentId);

}
