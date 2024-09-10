package com.baldefullstackdev.Abonnement_service.Models.Dto;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAbonnement {
    private String message;
}
