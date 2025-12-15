package ma.ws.jaxrs.repositories;

import ma.ws.jaxrs.entities.Compte;
import ma.ws.jaxrs.entities.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface CompteRepository extends JpaRepository<Compte, Long> {

    
    List<Compte> findByType(TypeCompte type);

  
    List<Compte> findBySoldeGreaterThan(double solde);

   
    List<Compte> findBySoldeLessThan(double solde);

   
    List<Compte> findBySoldeBetween(double soldeMin, double soldeMax);

  
    List<Compte> findByDateCreationAfter(Date date);

   
    List<Compte> findByDateCreationBefore(Date date);

  
    List<Compte> findByTypeAndSoldeGreaterThan(TypeCompte type, double solde);

  
    @Query("SELECT COUNT(c) FROM Compte c WHERE c.type = :type")
    long countByType(@Param("type") TypeCompte type);

  
    @Query("SELECT SUM(c.solde) FROM Compte c WHERE c.type = :type")
    Double getSommeSoldesByType(@Param("type") TypeCompte type);

   
    @Query("SELECT c FROM Compte c ORDER BY c.solde DESC")
    List<Compte> findAllOrderBySoldeDesc();

   
    @Query("SELECT c FROM Compte c WHERE c.dateCreation BETWEEN :dateDebut AND :dateFin")
    List<Compte> findByDateCreationBetween(@Param("dateDebut") Date dateDebut, @Param("dateFin") Date dateFin);
}
