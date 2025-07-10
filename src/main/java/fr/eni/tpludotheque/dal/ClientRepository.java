package fr.eni.tpludotheque.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.eni.tpludotheque.bo.Client;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    List<Client> findByNomStartingWith(String prefix);
}
