package com.baldefullstackdev.Theme_service.Models.Dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestTheme {

    @Column(nullable = false)
    private String titre;

    @Column(nullable = false)
    private String description;
}
