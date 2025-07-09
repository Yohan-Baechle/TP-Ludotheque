package fr.eni.tpludotheque.bo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClientTest {

    @BeforeAll
    public static void initBeforeAll() {
        System.out.println("Dans initBeforeAll");
    }

    @BeforeEach
    public void initBeforeEach() {
        System.out.println("Dans initBeforeEach");
    }

    @AfterEach
    public void methodeAfterEach() {
        System.out.println("Dans methodeAfterEach");
    }

    @AfterAll
    public static void methodeAfterAll() {
        System.out.println("Dans methodeAfterAll");
    }

    @Test
    @DisplayName("Cas négatif - ne doit pas créer de Client quand email est null")
    public void testCreationClientCasNegatifEmailNul() {
        assertThrows(NullPointerException.class, () ->
                new Client("Doe", "John", null)
        );
    }

    @Test
    @DisplayName("TEST CT001-S1003 création Client - Cas POSITIF")
    public void testCreationClient() {
        // Arrange
        String nom = "Doe";
        String prenom = "John";
        String email = "john.doe@example.com";

        // Act
        Client client = new Client(nom, prenom, email);
        client.setNoTelephone("0601020304");

        // Assert
        assertNotNull(client);
        assertEquals(nom, client.getNom());
        assertEquals(prenom, client.getPrenom());
        assertEquals(email, client.getEmail());
        assertEquals("0601020304", client.getNoTelephone());
    }
}
