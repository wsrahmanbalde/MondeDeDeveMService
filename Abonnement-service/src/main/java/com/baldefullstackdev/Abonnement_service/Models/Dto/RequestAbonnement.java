package com.baldefullstackdev.Abonnement_service.Models.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestAbonnement {
    @Column(nullable = false)
    private Long theme;
    @Column(nullable = false)
    private Long username;
}
