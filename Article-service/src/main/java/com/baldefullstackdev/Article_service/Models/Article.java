package com.baldefullstackdev.Article_service.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;

    @Column(nullable = false)
    private String titre;

    @Column(nullable = false)
    private String contenu;

    @Column(nullable = false)
    private Long topic;

    @Column(nullable = false)
    private Long auteur;

    @CreatedDate
    @Column(updatable = false,nullable = false)
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime create_at;

    @LastModifiedDate
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime update_at;

}
