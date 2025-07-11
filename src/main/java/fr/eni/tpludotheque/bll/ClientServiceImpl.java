package fr.eni.tpludotheque.bll;

import fr.eni.tpludotheque.bo.Adresse;
import fr.eni.tpludotheque.bo.Client;
import fr.eni.tpludotheque.dal.AdresseRepository;
import fr.eni.tpludotheque.dal.ClientRepository;
import fr.eni.tpludotheque.dto.AdresseDTO;
import fr.eni.tpludotheque.dto.ClientDTO;
import fr.eni.tpludotheque.exceptions.DataNotFound;
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
    public Client modifierClient(Integer id, ClientDTO clientDto) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new DataNotFound("Client", id));

        client.setNom(clientDto.getNom());
        client.setPrenom(clientDto.getPrenom());
        client.setEmail(clientDto.getEmail());
        client.setNoTelephone(clientDto.getNoTelephone());

        if (client.getAdresse() == null) {
            client.setAdresse(new Adresse());
        }
        client.getAdresse().setRue(clientDto.getRue());
        client.getAdresse().setCodePostal(clientDto.getCodePostal());
        client.getAdresse().setVille(clientDto.getVille());

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
}
