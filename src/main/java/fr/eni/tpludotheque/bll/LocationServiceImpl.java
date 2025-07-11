package fr.eni.tpludotheque.bll;

import fr.eni.tpludotheque.bo.Client;
import fr.eni.tpludotheque.bo.Exemplaire;
import fr.eni.tpludotheque.bo.Location;
import fr.eni.tpludotheque.dal.ExemplaireRepository;
import fr.eni.tpludotheque.dal.JeuRepository;
import fr.eni.tpludotheque.dal.LocationRepository;
import fr.eni.tpludotheque.dto.LocationDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService{
    @NonNull
    final private LocationRepository locationRepository;

    @NonNull
    final private JeuRepository jeuRepository;

    @NonNull
    final private ExemplaireRepository exemplaireRepository;


    @Override
    public Location ajouterLocation(LocationDTO locationDto  ) {
        Exemplaire exemplaire = exemplaireRepository.findByCodebarre(locationDto.getCodebarre());
        Client client = new Client();
        client.setId(locationDto.getNoClient());

        Location location = new Location(LocalDateTime.now(),client, exemplaire );
        BigDecimal tarifJour = jeuRepository.findTarifJour(exemplaire.getJeu().getId());
        location.setTarifJour(tarifJour);

        return locationRepository.save(location);
    }
}
