package com.baldefullstackdev.Abonnement_service.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Abonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long abonnementId;
    @Column(nullable = false)
    private Long theme;
    @Column(nullable = false)
    private Long username;
}
