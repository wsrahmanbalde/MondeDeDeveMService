package com.baldefullstackdev.Article_service.Services;

import com.baldefullstackdev.Article_service.Models.Article;
import com.baldefullstackdev.Article_service.Models.Dto.RequestArticle;
import com.baldefullstackdev.Article_service.Models.Dto.ResponseArticle;
import com.baldefullstackdev.Article_service.Models.Dto.ResponseFindArticle;

import java.util.List;

public interface ArticleService {
    ResponseFindArticle findArticleById(Long id);
    List<ResponseFindArticle> findAllArticles();
    ResponseArticle addArticle(RequestArticle requestArticle);
    ResponseArticle updateArticle(Long id, RequestArticle requestArticle);
    ResponseArticle deleteArticle(Long id);

    ResponseFindArticle convertArticleToDto(Article article);
    Article convertDtoToArticle(RequestArticle requestArticle);
}
