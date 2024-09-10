package com.baldefullstackdev.Abonnement_service.Models.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseFindAbonnement {
    private Long abonnementId;
    private Long theme;
    private Long username;
}
