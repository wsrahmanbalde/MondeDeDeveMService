package com.baldefullstackdev.Theme_service.Services;

import com.baldefullstackdev.Theme_service.Models.Dto.RequestTheme;
import com.baldefullstackdev.Theme_service.Models.Dto.ResponseFindTheme;
import com.baldefullstackdev.Theme_service.Models.Dto.ResponseTheme;
import com.baldefullstackdev.Theme_service.Models.Theme;
import com.baldefullstackdev.Theme_service.Repositories.ThemeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ThemeServiceImpl implements ThemeService{

    private final ThemeRepository themeRepository;
    private final ModelMapper modelMapper;

    @Override
    public ResponseFindTheme findThemeById(Long id) {
        if(themeRepository.findById(id).isEmpty()){
            return ResponseFindTheme.builder().build();
        }
        return convertThemeToDto(themeRepository.findById(id).get());
    }

    @Override
    public List<ResponseFindTheme> findThemes() {
        if(themeRepository.findAll().isEmpty()){
            return List.of();
        }
        return themeRepository.findAll()
                .stream()
                .map(this::convertThemeToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseTheme addTheme(RequestTheme requestTheme) {
        Theme theme = convertDtoToTheme(requestTheme);
        theme.setCreate_at(LocalDateTime.now());
        themeRepository.save(theme);
        return ResponseTheme
                .builder()
                .message("Theme ajouté avec succès")
                .build();
    }

    @Override
    public ResponseTheme updateTheme(Long id,RequestTheme requestTheme) {
        if(themeRepository.findById(id).isEmpty()){
            return ResponseTheme
                    .builder()
                    .message("Modification impossible,identifiant non trouvé")
                    .build();
        }
        Theme theme = convertDtoToTheme(requestTheme);
        theme.setThemeId(id);
        theme.setCreate_at(themeRepository.findById(id).get().getCreate_at());
        theme.setUpdate_at(LocalDateTime.now());
        themeRepository.save(theme);
        return ResponseTheme
                .builder()
                .message("Theme modifié avec succès")
                .build();
    }

    @Override
    public ResponseTheme deleteTheme(Long id) {
        if(themeRepository.findById(id).isEmpty()){
            return ResponseTheme
                    .builder()
                    .message("Suppression impossible,identifiant non trouvé")
                    .build();
        }
        themeRepository.deleteById(id);
        return ResponseTheme
                .builder()
                .message("Theme supprimé avec succès")
                .build();
    }

    @Override
    public ResponseFindTheme convertThemeToDto(Theme theme) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(theme,ResponseFindTheme.class);
    }

    @Override
    public Theme convertDtoToTheme(RequestTheme requestTheme) {
        return modelMapper.map(requestTheme,Theme.class);
    }
}
