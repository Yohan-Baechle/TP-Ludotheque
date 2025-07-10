package fr.eni.tpludotheque.bll;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import fr.eni.tpludotheque.bo.Adresse;
import fr.eni.tpludotheque.bo.Client;
import fr.eni.tpludotheque.dal.ClientRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class ClientServiceImplCTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServiceImpl clientService;

    @Test
    @DisplayName("S2008 - Ajouter un client et son adresse (DAL mockée) - Cas positif")
    public void testAjouterClientAvecAdresse() {
        // Arrange
        Adresse adresse = new Adresse("123 rue des Lilas", "75000", "Paris");
        Client client = new Client("Doe", "John", "john.doe@example.com");
        client.setNoTelephone("0601020304");
        client.setAdresse(adresse);

        // Simuler que la DAL renvoie le client avec un id généré
        Client clientAvecId = new Client("Doe", "John", "john.doe@example.com");
        clientAvecId.setId(1);
        clientAvecId.setNoTelephone("0601020304");
        clientAvecId.setAdresse(adresse);
        adresse.setId(2);

        when(clientRepository.save(client)).thenReturn(clientAvecId);

        // Act
        Client resultat = clientService.ajouterClient(client);

        // Assert
        assertNotNull(resultat, "Le client retourné ne doit pas être null");
        assertNotNull(resultat.getId(), "L'id du client doit être généré (mocké)");
        assertEquals(1, resultat.getId());
        assertNotNull(resultat.getAdresse(), "L'adresse ne doit pas être null");
        assertEquals("Paris", resultat.getAdresse().getVille(), "La ville doit être Paris");

        verify(clientRepository, times(1)).save(client);
    }
}
