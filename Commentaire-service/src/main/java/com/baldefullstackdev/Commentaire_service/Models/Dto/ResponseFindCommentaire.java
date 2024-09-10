package com.baldefullstackdev.Commentaire_service.Models.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseFindCommentaire {

    private Long commentaireId;

    private String contenu;

    private Long username;

    private Long article;

    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime create_at;

    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime update_at;

}
