package com.baldefullstackdev.Commentaire_service.Models.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestCommentaire {

    @Column(nullable = false)
    private String contenu;

    @Column(nullable = false)
    private Long username;

    @Column(nullable = false)
    private Long article;
}
