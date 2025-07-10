package fr.eni.tpludotheque.bll;

import fr.eni.tpludotheque.bo.Location;
import fr.eni.tpludotheque.dto.LocationDTO;

import java.util.List;

public interface LocationService {
    Location ajouterLocation(LocationDTO locationDto);
}
