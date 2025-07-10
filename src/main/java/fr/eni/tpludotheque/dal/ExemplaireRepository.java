package fr.eni.tpludotheque.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.eni.tpludotheque.bo.Exemplaire;

public interface ExemplaireRepository extends JpaRepository<Exemplaire, Integer>{
    Exemplaire findByCodebarre(String codebarre);
}
