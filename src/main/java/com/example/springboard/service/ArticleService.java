package com.example.springboard.service;

import com.example.springboard.common.exception.GlobalException;
import com.example.springboard.domain.articles.Article;
import com.example.springboard.repository.ArticleRepository;
import com.example.springboard.util.enums.ErrorTypeWithRequest;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Article getArticleByArticleId(int articleId) {
        return articleRepository.findArticleByArticleId(articleId).orElseThrow(() ->
            new GlobalException(Map.of("articleId", articleId),
                ErrorTypeWithRequest.ARTICLE_NOT_FOUND_BY_ID));
    }
}
