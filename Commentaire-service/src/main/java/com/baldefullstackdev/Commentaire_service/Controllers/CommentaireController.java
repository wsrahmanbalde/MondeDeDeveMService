package com.baldefullstackdev.Commentaire_service.Controllers;

import com.baldefullstackdev.Commentaire_service.Models.Dto.RequestCommentaire;
import com.baldefullstackdev.Commentaire_service.Models.Dto.ResponseCommentaire;
import com.baldefullstackdev.Commentaire_service.Models.Dto.ResponseFindCommentaire;
import com.baldefullstackdev.Commentaire_service.Services.CommentaireService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/commentaires")
public class CommentaireController {

    private final CommentaireService commentaireService;

    @GetMapping("/{id}")
    public ResponseFindCommentaire findCommentaireById(@PathVariable Long id){
        return commentaireService.findCommentaireById(id);
    }

    @GetMapping
    public List<ResponseFindCommentaire> findAllCommentaires(){
        return commentaireService.findAllCommentaires();
    }

    @PostMapping
    public ResponseCommentaire addCommentaire(@RequestBody RequestCommentaire requestCommentaire){
        return commentaireService.addCommentaire(requestCommentaire);
    }

    @PutMapping("/{id}")
    public ResponseCommentaire updateCommentaire(@PathVariable Long id,@RequestBody RequestCommentaire requestCommentaire){
        return commentaireService.updateCommentaire(id,requestCommentaire);
    }

    @DeleteMapping("/{id}")
    public ResponseCommentaire deleteCommentaire(@PathVariable Long id){
        return commentaireService.deleteCommentaire(id);
    }

}
