package com.baldefullstackdev.Theme_service.Models.Dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseTheme {
    private String message;
}
