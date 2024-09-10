package com.baldefullstackdev.Article_service.Client;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ThemeClient {
    private Long themeId;
    private String titre;
    private String description;
    private LocalDateTime create_at;
    private LocalDateTime update_at;
}
