package com.baldefullstackdev.Article_service.Models.Dto;

import com.baldefullstackdev.Article_service.Client.ThemeClient;
import jakarta.persistence.Column;
import jakarta.persistence.Transient;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestArticle {

    @Column(nullable = false)
    private String titre;

    @Column(nullable = false)
    private String contenu;

    @Column(nullable = false)
    private Long topic;

    @Column(nullable = false)
    private Long auteur;

}
