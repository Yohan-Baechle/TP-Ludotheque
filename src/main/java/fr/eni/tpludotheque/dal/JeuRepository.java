package fr.eni.tpludotheque.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.eni.tpludotheque.bo.Jeu;

public interface JeuRepository extends JpaRepository<Jeu, Integer> {

    Float findTarifJour(Integer id);
}
