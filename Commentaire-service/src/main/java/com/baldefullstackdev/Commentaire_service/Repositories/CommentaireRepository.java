package com.baldefullstackdev.Commentaire_service.Repositories;

import com.baldefullstackdev.Commentaire_service.Models.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire,Long> {
}
