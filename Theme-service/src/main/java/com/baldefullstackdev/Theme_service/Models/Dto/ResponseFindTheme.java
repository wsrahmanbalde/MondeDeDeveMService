package com.baldefullstackdev.Theme_service.Models.Dto;

import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseFindTheme {
    private Long themeId;
    private String titre;
    private String description;
    private LocalDateTime create_at;
    private LocalDateTime update_at;
}
