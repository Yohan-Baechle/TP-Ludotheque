package fr.eni.tpludotheque.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.eni.tpludotheque.bo.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
