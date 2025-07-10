package fr.eni.tpludotheque.bll;

import fr.eni.tpludotheque.bo.Client;

import java.util.List;

public interface ClientService {
    Client ajouterClient(Client client);
    List<Client> findClientsByNom(String prefix);
    Client modifierClient(Integer id, Client clientModifie);
}