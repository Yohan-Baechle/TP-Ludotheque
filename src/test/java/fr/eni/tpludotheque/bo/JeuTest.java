package fr.eni.tpludotheque.bo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class JeuTest {

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
    @DisplayName("Cas négatif - ne doit pas créer de Jeu quand titre est null")
    public void testCreationJeuCasNegatifTitreNul() {
        assertThrows(NullPointerException.class, () ->
                new Jeu(null, "REF001")
        );
    }

    @Test
    @DisplayName("Cas négatif - ne doit pas créer de Jeu quand reference est null")
    public void testCreationJeuCasNegatifReferenceNul() {
        assertThrows(NullPointerException.class, () ->
                new Jeu("Catan", null)
        );
    }

    @Test
    @DisplayName("TEST JT001-S1003 création Jeu - Cas POSITIF")
    public void testCreationJeu() {
        // Arrange
        String titre = "Catan";
        String reference = "REF001";
        Integer ageMin = 10;
        String description = "Jeu de stratégie populaire.";
        Integer duree = 90;
        BigDecimal tarifJour = new BigDecimal("5.50");

        // Act
        Jeu jeu = new Jeu(titre, reference);
        jeu.setAgeMin(ageMin);
        jeu.setDescription(description);
        jeu.setDuree(duree);
        jeu.setTarifJour(tarifJour);

        // Assert
        assertNotNull(jeu);
        assertEquals(titre, jeu.getTitre());
        assertEquals(reference, jeu.getReference());
        assertEquals(ageMin, jeu.getAgeMin());
        assertEquals(description, jeu.getDescription());
        assertEquals(duree, jeu.getDuree());
        assertEquals(tarifJour, jeu.getTarifJour());
    }
}
