package com.baldefullstackdev.Theme_service.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long themeId;

    @Column(nullable = false)
    private String titre;

    @Column(nullable = false)
    private String description;

    @CreatedDate
    @Column(updatable = false,nullable = false)
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime create_at;

    @LastModifiedDate
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime update_at;
}
