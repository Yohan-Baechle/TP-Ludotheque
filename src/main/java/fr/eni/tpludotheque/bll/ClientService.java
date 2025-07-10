package fr.eni.tpludotheque.bll;

import fr.eni.tpludotheque.bo.Client;
import fr.eni.tpludotheque.dto.ClientDTO;

import java.util.List;

public interface ClientService {
    Client ajouterClient(Client client);
    List<Client> findClientsByNom(String prefix);
    public Client modifierClient(Integer noClient, ClientDTO clientDto);
}