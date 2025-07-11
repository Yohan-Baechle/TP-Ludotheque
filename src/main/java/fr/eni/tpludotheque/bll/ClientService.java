package fr.eni.tpludotheque.bll;

import fr.eni.tpludotheque.bo.Client;
import fr.eni.tpludotheque.dto.AdresseDTO;
import fr.eni.tpludotheque.dto.ClientDTO;

import java.util.List;

public interface ClientService {
    Client getClientById(Integer id);
    Client ajouterClient(Client client);
    List<Client> findClientsByNom(String prefix);
    public Client modifierClient(Integer noClient, ClientDTO clientDto);
    public Client modifierAdresseClient(Integer noClient, AdresseDTO adresseDto);
    List<Client> getAllClients();
    Client ajouterClient(ClientDTO clientDTO);
    void supprimerClient(Integer id);
}