package com.baldefullstackdev.Article_service.Models.Dto;

import com.baldefullstackdev.Article_service.Client.ThemeClient;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Transient;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseFindArticle {

    private Long articleId;

    private String titre;

    private String contenu;

    private Long topic;

    private ThemeClient themeClient;


    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime create_at;

    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime update_at;

}
