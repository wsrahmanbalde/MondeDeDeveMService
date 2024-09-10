package com.baldefullstackdev.Theme_service.Services;

import com.baldefullstackdev.Theme_service.Models.Dto.RequestTheme;
import com.baldefullstackdev.Theme_service.Models.Dto.ResponseFindTheme;
import com.baldefullstackdev.Theme_service.Models.Dto.ResponseTheme;
import com.baldefullstackdev.Theme_service.Models.Theme;

import java.util.List;

public interface ThemeService {
    ResponseFindTheme findThemeById(Long id);
    List<ResponseFindTheme> findThemes();
    ResponseTheme addTheme(RequestTheme requestTheme);
    ResponseTheme updateTheme(Long id,RequestTheme requestTheme);
    ResponseTheme deleteTheme(Long id);

    ResponseFindTheme convertThemeToDto(Theme theme);
    Theme convertDtoToTheme(RequestTheme requestTheme);
}
