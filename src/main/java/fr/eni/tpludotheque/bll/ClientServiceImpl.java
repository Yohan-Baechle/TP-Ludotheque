package fr.eni.tpludotheque.bll;

import fr.eni.tpludotheque.bo.Adresse;
import fr.eni.tpludotheque.bo.Client;
import fr.eni.tpludotheque.dal.AdresseRepository;
import fr.eni.tpludotheque.dal.ClientRepository;
import fr.eni.tpludotheque.dto.AdresseDTO;
import fr.eni.tpludotheque.dto.ClientDTO;
import fr.eni.tpludotheque.exceptions.DataNotFound;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private AdresseRepository adresseRepository;

    // Injection par constructeur
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client ajouterClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> findClientsByNom(String prefix) {
        return clientRepository.findByNomStartingWith(prefix);
    }

    @Override
    public Client modifierClient(Integer noClient, ClientDTO clientDto) {
        Client client = clientRepository.findById(noClient)
                .orElseThrow(() -> new EntityNotFoundException("Client avec l'id " + noClient + " non trouvé."));

        // Mise à jour des informations du client
        client.setNom(clientDto.getNom());
        client.setPrenom(clientDto.getPrenom());
        client.setEmail(clientDto.getEmail());
        client.setNoTelephone(clientDto.getNoTelephone());

        // Mise à jour de l'adresse associée
        Adresse adresse = client.getAdresse();
        if (adresse == null) {
            adresse = new Adresse();
        }
        adresse.setRue(clientDto.getRue());
        adresse.setCodePostal(clientDto.getCodePostal());
        adresse.setVille(clientDto.getVille());

        client.setAdresse(adresse);

        return clientRepository.save(client);
    }


    @Override
    public Client modifierAdresseClient(Integer id, AdresseDTO adresseDto) {
        Client client = clientRepository.findById(id).orElseThrow(()->new DataNotFound("Client", id));

        BeanUtils.copyProperties(adresseDto, client.getAdresse());

        adresseRepository.save(client.getAdresse());

        return client;

    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client ajouterClient(ClientDTO clientDTO) {
        Adresse adresse = new Adresse(
                clientDTO.getRue(),
                clientDTO.getCodePostal(),
                clientDTO.getVille()
        );

        Client client = new Client(
                clientDTO.getNom(),
                clientDTO.getPrenom(),
                clientDTO.getEmail()
        );
        client.setNoTelephone(clientDTO.getNoTelephone());
        client.setAdresse(adresse);

        return clientRepository.save(client);
    }

    @Override
    public void supprimerClient(Integer id) {
        if (!clientRepository.existsById(id)) {
            throw new EntityNotFoundException("Client avec l'id " + id + " non trouvé.");
        }
        clientRepository.deleteById(id);
    }
}
