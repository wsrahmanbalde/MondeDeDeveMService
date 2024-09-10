package com.baldefullstackdev.Theme_service.Controllers;

import com.baldefullstackdev.Theme_service.Models.Dto.RequestTheme;
import com.baldefullstackdev.Theme_service.Models.Dto.ResponseFindTheme;
import com.baldefullstackdev.Theme_service.Models.Dto.ResponseTheme;
import com.baldefullstackdev.Theme_service.Services.ThemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/themes")
public class ThemeController {

    private final ThemeService themeService;

    @GetMapping("/{id}")
    public ResponseFindTheme findThemeById(@PathVariable Long id){
        return themeService.findThemeById(id);
    }

    @GetMapping
    public List<ResponseFindTheme> findAllThemes(){
        return themeService.findThemes();
    }

    @PostMapping
    public ResponseTheme addTheme(@RequestBody RequestTheme requestTheme){
        return themeService.addTheme(requestTheme);
    }

    @PutMapping("/{id}")
    public ResponseTheme putTheme(@PathVariable Long id,@RequestBody RequestTheme requestTheme){
        return themeService.updateTheme(id,requestTheme);
    }

    @DeleteMapping("/{id}")
    public ResponseTheme deleteTheme(@PathVariable Long id){
        return themeService.deleteTheme(id);
    }
}
