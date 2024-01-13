package com.example.springboard.service;

import com.example.springboard.common.exception.article.ArticleNotFoundException;
import com.example.springboard.domain.articles.Article;
import com.example.springboard.repository.ArticleRepository;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Article getArticleByArticleId(int articleId) {
        return articleRepository.findArticleByArticleId(articleId).orElseThrow(
            ArticleNotFoundException::new);
    }
}
