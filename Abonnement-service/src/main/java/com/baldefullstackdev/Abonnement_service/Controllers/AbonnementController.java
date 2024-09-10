package com.baldefullstackdev.Abonnement_service.Controllers;

import com.baldefullstackdev.Abonnement_service.Models.Dto.RequestAbonnement;
import com.baldefullstackdev.Abonnement_service.Models.Dto.ResponseAbonnement;
import com.baldefullstackdev.Abonnement_service.Models.Dto.ResponseFindAbonnement;
import com.baldefullstackdev.Abonnement_service.Services.AbonnementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/abonnements")
public class AbonnementController {

    private final AbonnementService abonnementService;

    @GetMapping("/{id}")
    public ResponseFindAbonnement findAbonnementById(@PathVariable Long id){
        return abonnementService.findAbonnementById(id);
    }

    @GetMapping
    public List<ResponseFindAbonnement> findAllAbonnements(){
        return abonnementService.findAllAbonnements();
    }

    @PostMapping
    public ResponseAbonnement addAbonnement(@RequestBody RequestAbonnement requestAbonnement){
        return abonnementService.addAbonnement(requestAbonnement);
    }

    @PutMapping("/{id}")
    public ResponseAbonnement updateAbonnement(@PathVariable Long id,@RequestBody RequestAbonnement requestAbonnement){
        return abonnementService.updateAbonnement(id,requestAbonnement);
    }

    @DeleteMapping("/{id}")
    public ResponseAbonnement deleteAbonnement(@PathVariable Long id){
        return abonnementService.deleteAbonnement(id);
    }


}
