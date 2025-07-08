package fr.eni.tpludotheque.dal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.eni.tpludotheque.bo.Client;

@SpringBootTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    @DisplayName("Création d'un client avec JPA")
    public void testCreationClient() {
        // Arrange
        long nbClients = clientRepository.count();
        Client client = new Client("Doe", "John", "john.doe@example.com");
        client.setNoTelephone("0601020304");

        // Act
        clientRepository.save(client);

        // Assert
        assertNotNull(client.getNoClient(), "L'id du client doit être généré");
        assertEquals(nbClients + 1, clientRepository.count(), "Le nombre de clients doit augmenter de 1");
    }

    @Test
    @DisplayName("Recherche d'un client avec JPA")
    public void testFindByIdClient() {
        // Arrange
        Client client = new Client("Doe", "John", "john.doe2@example.com");
        client.setNoTelephone("0601020305");
        clientRepository.save(client);
        Integer idClient = client.getNoClient();

        // Act
        Optional<Client> clientOpt = clientRepository.findById(idClient);

        // Assert
        assertTrue(clientOpt.isPresent(), "Le client doit être présent en base");
        assertEquals(idClient, clientOpt.get().getNoClient(), "L'id du client doit correspondre");
    }

    @Test
    @DisplayName("Modification d'un client avec JPA")
    public void testModificationClient() {
        // Arrange
        Client client = new Client("Doe", "John", "john.doe3@example.com");
        client.setNoTelephone("0601020306");
        clientRepository.save(client);
        Integer idClient = client.getNoClient();

        // Act
        client.setNom("Durand");
        client.setPrenom("Paul");
        clientRepository.save(client);

        // Assert
        Optional<Client> clientModifieOpt = clientRepository.findById(idClient);
        assertTrue(clientModifieOpt.isPresent(), "Le client modifié doit être présent");
        assertEquals("Durand", clientModifieOpt.get().getNom(), "Le nom doit être mis à jour");
        assertEquals("Paul", clientModifieOpt.get().getPrenom(), "Le prénom doit être mis à jour");
    }
}
