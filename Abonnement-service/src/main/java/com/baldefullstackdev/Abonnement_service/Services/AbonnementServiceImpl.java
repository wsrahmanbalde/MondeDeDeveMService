package com.baldefullstackdev.Abonnement_service.Services;

import com.baldefullstackdev.Abonnement_service.Models.Abonnement;
import com.baldefullstackdev.Abonnement_service.Models.Dto.RequestAbonnement;
import com.baldefullstackdev.Abonnement_service.Models.Dto.ResponseAbonnement;
import com.baldefullstackdev.Abonnement_service.Models.Dto.ResponseFindAbonnement;
import com.baldefullstackdev.Abonnement_service.Repositories.AbonnementRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AbonnementServiceImpl implements AbonnementService{

    private final AbonnementRepository abonnementRepository;
    private final ModelMapper modelMapper;
    @Override
    public ResponseFindAbonnement findAbonnementById(Long id) {
        if(abonnementRepository.findById(id).isEmpty()){
            return ResponseFindAbonnement.builder().build();
        }
        return convertAbonnementToDto(abonnementRepository.findById(id).get());
    }

    @Override
    public List<ResponseFindAbonnement> findAllAbonnements() {
        if(abonnementRepository.findAll().isEmpty()){
            return List.of();
        }
        return abonnementRepository.findAll()
                .stream()
                .map(this::convertAbonnementToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseAbonnement addAbonnement(RequestAbonnement requestAbonnement) {
        Abonnement abonnement = convertDtoToAbonnement(requestAbonnement);
        abonnementRepository.save(abonnement);
        return ResponseAbonnement
                .builder()
                .message("Ajout effectué avec succès add")
                .build();
    }

    @Override
    public ResponseAbonnement updateAbonnement(Long id, RequestAbonnement requestAbonnement) {
        if(abonnementRepository.findById(id).isEmpty()){
            return ResponseAbonnement
                    .builder()
                    .message("Oups! Mise a jour non effectué")
                    .build();
        }

        Abonnement newAbonnement = convertDtoToAbonnement(requestAbonnement);
        newAbonnement.setAbonnementId(id);
        abonnementRepository.save(newAbonnement);
        return ResponseAbonnement
                .builder()
                .message("Mise a jour effectué avec succès")
                .build();
    }

    @Override
    public ResponseAbonnement deleteAbonnement(Long id) {
        if(abonnementRepository.findById(id).isEmpty()){
            return ResponseAbonnement
                    .builder()
                    .message("Suppression non effectué ")
                    .build();
        }

        abonnementRepository.deleteById(id);
        return ResponseAbonnement
                .builder()
                .message("Suppression effectué avec succès ")
                .build();
    }

    @Override
    public ResponseFindAbonnement convertAbonnementToDto(Abonnement abonnement) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(abonnement,ResponseFindAbonnement.class);
    }

    @Override
    public Abonnement convertDtoToAbonnement(RequestAbonnement requestAbonnement) {
        return modelMapper.map(requestAbonnement, Abonnement.class);
    }
}
