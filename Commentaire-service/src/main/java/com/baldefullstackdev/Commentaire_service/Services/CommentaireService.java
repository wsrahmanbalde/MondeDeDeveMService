package com.baldefullstackdev.Commentaire_service.Services;

import com.baldefullstackdev.Commentaire_service.Models.Commentaire;
import com.baldefullstackdev.Commentaire_service.Models.Dto.RequestCommentaire;
import com.baldefullstackdev.Commentaire_service.Models.Dto.ResponseCommentaire;
import com.baldefullstackdev.Commentaire_service.Models.Dto.ResponseFindCommentaire;

import java.util.List;

public interface CommentaireService {
    ResponseFindCommentaire findCommentaireById(Long id);
    List<ResponseFindCommentaire> findAllCommentaires();
    ResponseCommentaire addCommentaire(RequestCommentaire requestCommentaire);
    ResponseCommentaire updateCommentaire(Long id, RequestCommentaire requestCommentaire);
    ResponseCommentaire deleteCommentaire(Long id);

    ResponseFindCommentaire convertCommentaireToDto(Commentaire commentaire);
    Commentaire convertDtoToCommentaire(RequestCommentaire requestCommentaire);
}
