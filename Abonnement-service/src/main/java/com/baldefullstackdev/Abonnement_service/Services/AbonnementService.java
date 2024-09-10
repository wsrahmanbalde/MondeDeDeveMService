package com.baldefullstackdev.Abonnement_service.Services;

import com.baldefullstackdev.Abonnement_service.Models.Abonnement;
import com.baldefullstackdev.Abonnement_service.Models.Dto.RequestAbonnement;
import com.baldefullstackdev.Abonnement_service.Models.Dto.ResponseAbonnement;
import com.baldefullstackdev.Abonnement_service.Models.Dto.ResponseFindAbonnement;

import java.util.List;

public interface AbonnementService {
    ResponseFindAbonnement findAbonnementById(Long id);
    List<ResponseFindAbonnement> findAllAbonnements();
    ResponseAbonnement addAbonnement(RequestAbonnement requestAbonnement);
    ResponseAbonnement updateAbonnement(Long id, RequestAbonnement requestAbonnement);
    ResponseAbonnement deleteAbonnement(Long id);

    ResponseFindAbonnement convertAbonnementToDto(Abonnement  abonnement);
    Abonnement convertDtoToAbonnement(RequestAbonnement requestAbonnement);
}
