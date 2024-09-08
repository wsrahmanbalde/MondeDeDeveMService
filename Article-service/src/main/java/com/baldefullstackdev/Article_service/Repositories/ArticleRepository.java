package com.baldefullstackdev.Article_service.Repositories;

import com.baldefullstackdev.Article_service.Models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {
}
