package fr.eni.tpludotheque.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.eni.tpludotheque.bo.Jeu;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface JeuRepository extends JpaRepository<Jeu, Integer> {
    @Query(nativeQuery = true, value="select tarif_jour from jeu where id = :idJeu")
    BigDecimal findTarifJour(@Param("id") Integer id);
}
