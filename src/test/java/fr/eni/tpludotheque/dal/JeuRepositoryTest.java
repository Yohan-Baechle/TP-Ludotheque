package fr.eni.tpludotheque.dal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import fr.eni.tpludotheque.bo.Jeu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;

@SpringBootTest
public class JeuRepositoryTest {

    @Autowired
    private JeuRepository jeuRepository;

    @Test
    @DisplayName("Création d'un jeu avec JPA")
    public void testCreationJeu() {
        // Arrange
        long nbJeux = jeuRepository.count();
        Jeu jeu = new Jeu("Catan", "REFCATAN");
        jeu.setAgeMin(10);
        jeu.setDescription("Jeu de stratégie de gestion de ressources.");
        jeu.setDuree(90);
        jeu.setTarifJour(new BigDecimal("4.50"));

        // Act
        jeuRepository.save(jeu);

        // Assert
        assertNotNull(jeu.getId(), "L'id du jeu doit être généré");
        assertEquals(nbJeux + 1, jeuRepository.count(), "Le nombre de jeux doit augmenter de 1");
    }

    @Test
    @DisplayName("Recherche d'un jeu avec JPA")
    public void testFindByIdJeu() {
        // Arrange
        Jeu jeu = new Jeu("Carcassonne", "REFCARCA");
        jeu.setAgeMin(8);
        jeu.setDescription("Jeu de placement de tuiles et de meeples.");
        jeu.setDuree(45);
        jeu.setTarifJour(new BigDecimal("3.00"));
        jeuRepository.save(jeu);
        Integer idJeu = jeu.getId();

        // Act
        Optional<Jeu> jeuOpt = jeuRepository.findById(idJeu);

        // Assert
        assertTrue(jeuOpt.isPresent(), "Le jeu doit être présent en base");
        assertEquals(idJeu, jeuOpt.get().getId(), "L'id du jeu doit correspondre");
        assertEquals("Carcassonne", jeuOpt.get().getTitre(), "Le titre doit correspondre");
    }

    @Test
    @DisplayName("Modification d'un jeu avec JPA")
    public void testModificationJeu() {
        // Arrange
        Jeu jeu = new Jeu("7 Wonders", "REF7WON");
        jeu.setAgeMin(10);
        jeu.setDescription("Jeu de civilisation rapide.");
        jeu.setDuree(30);
        jeu.setTarifJour(new BigDecimal("3.50"));
        jeuRepository.save(jeu);
        Integer idJeu = jeu.getId();

        // Act
        jeu.setTitre("7 Wonders Duel");
        jeu.setDuree(45);
        jeuRepository.save(jeu);

        // Assert
        Optional<Jeu> jeuModifieOpt = jeuRepository.findById(idJeu);
        assertTrue(jeuModifieOpt.isPresent(), "Le jeu modifié doit être présent");
        assertEquals("7 Wonders Duel", jeuModifieOpt.get().getTitre(), "Le titre doit être mis à jour");
        assertEquals(45, jeuModifieOpt.get().getDuree(), "La durée doit être mise à jour");
    }
}
