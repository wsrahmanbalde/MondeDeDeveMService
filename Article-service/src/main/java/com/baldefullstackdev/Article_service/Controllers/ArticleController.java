package com.baldefullstackdev.Article_service.Controllers;

import com.baldefullstackdev.Article_service.Models.Dto.RequestArticle;
import com.baldefullstackdev.Article_service.Models.Dto.ResponseArticle;
import com.baldefullstackdev.Article_service.Models.Dto.ResponseFindArticle;
import com.baldefullstackdev.Article_service.Services.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/articles")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/{id}")
    public ResponseFindArticle findArticleById(@PathVariable Long id){
        return articleService.findArticleById(id);
    }

    @GetMapping
    public List<ResponseFindArticle> findAllArticles(){
        return articleService.findAllArticles();
    }

    @PostMapping
    public ResponseArticle addArticle(@RequestBody RequestArticle requestArticle){
        return articleService.addArticle(requestArticle);
    }

    @PutMapping("/{id}")
    public ResponseArticle updateArticle(@PathVariable Long id,@RequestBody RequestArticle requestArticle){
        return articleService.updateArticle(id,requestArticle);
    }

    @DeleteMapping("/{id}")
    public ResponseArticle deleteArticle(@PathVariable Long id){
        return articleService.deleteArticle(id);
    }



}
