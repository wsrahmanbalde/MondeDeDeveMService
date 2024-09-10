package com.baldefullstackdev.Abonnement_service.Repositories;

import com.baldefullstackdev.Abonnement_service.Models.Abonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbonnementRepository extends JpaRepository<Abonnement,Long> {
}
