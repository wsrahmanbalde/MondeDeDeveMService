package com.baldefullstackdev.Commentaire_service.Models;

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
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentaireId;

    @Column(nullable = false)
    private String contenu;

    @Column(nullable = false)
    private Long username;

    @Column(nullable = false)
    private Long article;

    @CreatedDate
    @Column(updatable = false,nullable = false)
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime create_at;

    @LastModifiedDate
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime update_at;
}
