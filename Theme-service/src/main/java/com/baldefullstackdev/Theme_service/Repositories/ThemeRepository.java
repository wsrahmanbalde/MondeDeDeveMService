package com.baldefullstackdev.Theme_service.Repositories;

import com.baldefullstackdev.Theme_service.Models.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepository extends JpaRepository<Theme,Long> {
}
