package fr.eni.tpludotheque.bll;

import fr.eni.tpludotheque.bo.Client;
import fr.eni.tpludotheque.dal.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

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
}
