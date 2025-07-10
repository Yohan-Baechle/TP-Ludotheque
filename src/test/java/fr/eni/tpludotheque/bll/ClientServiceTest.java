package fr.eni.tpludotheque.bll;

import fr.eni.tpludotheque.bo.Client;
import fr.eni.tpludotheque.dal.ClientRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ClientServiceTest {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientRepository clientRepository;

    @Test
    @DisplayName("S2009 - Trouver les clients dont le nom commence par une chaîne donnée")
    public void findClientsByNomStartingWithCasDroit() {
        // Arrange
        Client c1 = new Client("Dupont", "Alice", "alice.dupont@example.com");
        Client c2 = new Client("Durand", "Bob", "bob.durand@example.com");
        Client c3 = new Client("Martin", "Charlie", "charlie.martin@example.com");
        clientRepository.save(c1);
        clientRepository.save(c2);
        clientRepository.save(c3);

        // Act
        List<Client> clients = clientService.findClientsByNom("Du");

        // Assert
        assertNotNull(clients, "La liste des clients ne doit pas être null");
        assertThat(clients)
                .extracting(Client::getNom)
                .containsExactlyInAnyOrder("Dupont", "Durand");
    }
}
