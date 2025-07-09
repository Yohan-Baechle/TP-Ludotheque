package fr.eni.tpludotheque.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.eni.tpludotheque.bo.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {

}
