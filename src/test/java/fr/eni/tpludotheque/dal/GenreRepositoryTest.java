package fr.eni.tpludotheque.dal;

import fr.eni.tpludotheque.bo.Genre;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GenreRepositoryTest {

    @Autowired
    private GenreRepository genreRepository;

    @Test
    @DisplayName("Création d'un genre avec JPA")
    public void testCreationGenre() {
        // Arrange
        long nbGenres = genreRepository.count();
        Genre genre = new Genre("Jeux de société");

        // Act
        genreRepository.save(genre);

        // Assert
        assertNotNull(genre.getId(), "L'id du genre doit être généré");
        assertEquals(nbGenres + 1, genreRepository.count(), "Le nombre de genres doit augmenter de 1");

        Genre genreFromDb = genreRepository.findById(genre.getId()).orElse(null);
        assertNotNull(genreFromDb, "Le genre doit être présent en base après sauvegarde");
        assertEquals("Jeux de société", genreFromDb.getLibelle(), "Le libellé doit être correctement sauvegardé");
    }
}
