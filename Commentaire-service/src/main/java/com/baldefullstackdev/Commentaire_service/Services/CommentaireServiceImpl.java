package com.baldefullstackdev.Commentaire_service.Services;

import com.baldefullstackdev.Commentaire_service.Models.Commentaire;
import com.baldefullstackdev.Commentaire_service.Models.Dto.RequestCommentaire;
import com.baldefullstackdev.Commentaire_service.Models.Dto.ResponseCommentaire;
import com.baldefullstackdev.Commentaire_service.Models.Dto.ResponseFindCommentaire;
import com.baldefullstackdev.Commentaire_service.Repositories.CommentaireRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentaireServiceImpl implements CommentaireService{

    private final CommentaireRepository commentaireRepository;
    private final ModelMapper modelMapper;

    @Override
    public ResponseFindCommentaire findCommentaireById(Long id) {
        if(commentaireRepository.findById(id).isEmpty()){
            return ResponseFindCommentaire.builder().build();
        }
        return convertCommentaireToDto(commentaireRepository.findById(id).get());
    }

    @Override
    public List<ResponseFindCommentaire> findAllCommentaires() {
        if(commentaireRepository.findAll().isEmpty()){
            return List.of();
        }
        return commentaireRepository.findAll()
                .stream()
                .map(this::convertCommentaireToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseCommentaire addCommentaire(RequestCommentaire requestCommentaire) {
        Commentaire commentaire = convertDtoToCommentaire(requestCommentaire);
        commentaire.setCreate_at(LocalDateTime.now());
        commentaireRepository.save(commentaire);
        return ResponseCommentaire
                .builder()
                .message("Ajout effectué avec succès add")
                .build();
    }

    @Override
    public ResponseCommentaire updateCommentaire(Long id, RequestCommentaire requestCommentaire) {

        if(commentaireRepository.findById(id).isEmpty()){
            return ResponseCommentaire
                    .builder()
                    .message("Oups! Mise a jour non effectué")
                    .build();
        }

        Commentaire newCommentaire = convertDtoToCommentaire(requestCommentaire);
        newCommentaire.setCommentaireId(id);
        newCommentaire.setCreate_at(commentaireRepository.findById(id).get().getCreate_at());
        newCommentaire.setUpdate_at(LocalDateTime.now());
        commentaireRepository.save(newCommentaire);
        return ResponseCommentaire
                .builder()
                .message("Mise a jour effectué avec succès")
                .build();
    }

    @Override
    public ResponseCommentaire deleteCommentaire(Long id) {
        if(commentaireRepository.findById(id).isEmpty()){
            return ResponseCommentaire
                    .builder()
                    .message("Suppression non effectué ")
                    .build();
        }

        commentaireRepository.deleteById(id);
        return ResponseCommentaire
                .builder()
                .message("Suppression effectué avec succès ")
                .build();
    }

    @Override
    public ResponseFindCommentaire convertCommentaireToDto(Commentaire commentaire) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(commentaire,ResponseFindCommentaire.class);
    }

    @Override
    public Commentaire convertDtoToCommentaire(RequestCommentaire requestCommentaire) {
        return modelMapper.map(requestCommentaire,Commentaire.class);
    }
}
