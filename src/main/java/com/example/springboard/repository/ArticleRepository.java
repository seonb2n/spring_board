package com.example.springboard.repository;

import com.example.springboard.domain.articles.Article;
import com.example.springboard.mapper.ArticleMapper;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleRepository {

    private final ArticleMapper articleMapper;

    public ArticleRepository(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    public Optional<Article> findArticleByArticleId(Integer articleId) {
        return Optional.ofNullable(articleMapper.findArticleByArticleId(articleId));
    }
}
