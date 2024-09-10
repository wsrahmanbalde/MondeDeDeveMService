package com.baldefullstackdev.Article_service.Client;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient("THEME-SERVICE")
public interface ThemeRestClient {
    @CircuitBreaker(name = "customerService" , fallbackMethod = "getDefaultTheme")
    @GetMapping("/api/v1/themes/{id}")
    ThemeClient findTheme(@PathVariable Long id);

    @CircuitBreaker(name = "customerService" , fallbackMethod = "getDefaultThemes")
    @GetMapping("/api/v1/themes/{id}")
    List<ThemeClient> findAllTheme();

    default ThemeClient getDefaultTheme(Long id , Exception e){
        return ThemeClient
                .builder()
                .themeId(0L)
                .titre("default titre")
                .description("default description")
                .create_at(LocalDateTime.now())
                .update_at(LocalDateTime.now())
                .build();
    }

    default List<ThemeClient> getDefaultThemes(Long id , Exception e){
        return List.of();
    }

}
