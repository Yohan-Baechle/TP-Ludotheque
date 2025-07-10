package fr.eni.tpludotheque.dal;

import fr.eni.tpludotheque.bo.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer>{
}
