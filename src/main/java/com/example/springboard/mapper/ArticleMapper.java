package com.example.springboard.mapper;

import com.example.springboard.domain.articles.Article;

public interface ArticleMapper {

    Article findArticleByArticleId(Integer articleId);

}
