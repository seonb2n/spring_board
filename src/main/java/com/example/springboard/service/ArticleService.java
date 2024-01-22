package com.example.springboard.service;

import com.example.springboard.common.exception.article.ArticleNotFoundException;
import com.example.springboard.domain.articles.Article;
import com.example.springboard.dto.request.article.ArticleCreateRequest;
import com.example.springboard.repository.ArticleRepository;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    /**
     * ArticleId 로 게시물 조회
     *
     * @param articleId
     * @return
     */
    public Article getArticleByArticleId(int articleId) {
        return articleRepository.findArticleByArticleId(articleId).orElseThrow(
            ArticleNotFoundException::new);
    }

    /**
     * 게시물 생성
     *
     * @param articleCreateRequest
     * @return
     */
    public Article createArticle(ArticleCreateRequest articleCreateRequest, int userId,
        int boardId) {
        Article article = Article.of(userId, boardId, articleCreateRequest.getTitle(),
            articleCreateRequest.getContent());
        int articleId = articleRepository.createArticle(article);
        article.setId(articleId);
        return article;
    }
}
