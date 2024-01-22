package com.example.springboard.mapper;

import com.example.springboard.domain.articles.Article;
import java.util.List;

public interface ArticleMapper {

    Article findArticleByArticleId(Integer articleId);

    List<Article> findArticleByBoardId(Integer boardId);

    int createArticle(Article article);
}
