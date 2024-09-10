package com.baldefullstackdev.Article_service.Services;

import com.baldefullstackdev.Article_service.Client.ThemeClient;
import com.baldefullstackdev.Article_service.Client.ThemeRestClient;
import com.baldefullstackdev.Article_service.Models.Article;
import com.baldefullstackdev.Article_service.Models.Dto.RequestArticle;
import com.baldefullstackdev.Article_service.Models.Dto.ResponseArticle;
import com.baldefullstackdev.Article_service.Models.Dto.ResponseFindArticle;
import com.baldefullstackdev.Article_service.Repositories.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService{

    private final ArticleRepository articleRepository;
    private final ModelMapper modelMapper;
    private final ThemeRestClient themeRestClient;
    @Override
    public ResponseFindArticle findArticleById(Long id) {
        if(articleRepository.findById(id).isEmpty()){
            return ResponseFindArticle.builder().build();
        }
        ResponseFindArticle responseFindArticle = convertArticleToDto(articleRepository.findById(id).get());
        responseFindArticle.setThemeClient(themeRestClient.findTheme(responseFindArticle.getTopic()));
        return responseFindArticle;
    }

    @Override
    public List<ResponseFindArticle> findAllArticles() {

        if(articleRepository.findAll().isEmpty()){
            return List.of();
        }
        List<ResponseFindArticle> responseFindArticles =
            articleRepository.findAll()
                .stream()
                .map(this::convertArticleToDto)
                .toList();

                responseFindArticles.forEach(theme->{
                    theme.setThemeClient(themeRestClient.findTheme(theme.getTopic()));
                });
        return responseFindArticles;
    }

    @Override
    public ResponseArticle addArticle(RequestArticle requestArticle) {
        ThemeClient themeClient = themeRestClient.findTheme(requestArticle.getTopic());
        if(themeClient.getThemeId() == null){
            return ResponseArticle
                    .builder()
                    .message("Le topic utilisé n'existe pas")
                    .build();
        }
        Article article = convertDtoToArticle(requestArticle);
        article.setCreate_at(LocalDateTime.now());
        articleRepository.save(article);
        return ResponseArticle
                .builder()
                .message("Ajout effectué avec succès add")
                .build();
    }

    @Override
    public ResponseArticle updateArticle(Long id,RequestArticle requestArticle) {

        if(articleRepository.findById(id).isEmpty()){
            return ResponseArticle
                    .builder()
                    .message("Oups! Mise a jour non effectué")
                    .build();
        }

        Article newArticle = convertDtoToArticle(requestArticle);
        newArticle.setArticleId(id);
        newArticle.setCreate_at(articleRepository.findById(id).get().getCreate_at());
        newArticle.setUpdate_at(LocalDateTime.now());
        articleRepository.save(newArticle);
        return ResponseArticle
                .builder()
                .message("Mise a jour effectué avec succès")
                .build();
    }

    @Override
    public ResponseArticle deleteArticle(Long id) {
        if(articleRepository.findById(id).isEmpty()){
            return ResponseArticle
                    .builder()
                    .message("Suppression non effectué ")
                    .build();
        }

        articleRepository.deleteById(id);
        return ResponseArticle
                .builder()
                .message("Suppression effectué avec succès ")
                .build();
    }

    @Override
    public ResponseFindArticle convertArticleToDto(Article article) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(article,ResponseFindArticle.class);
    }

    @Override
    public Article convertDtoToArticle(RequestArticle requestArticle) {
        return modelMapper.map(requestArticle,Article.class);
    }
}
