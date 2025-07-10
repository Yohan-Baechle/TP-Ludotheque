package fr.eni.tpludotheque.bll;

import fr.eni.tpludotheque.bo.Genre;
import fr.eni.tpludotheque.bo.Jeu;
import fr.eni.tpludotheque.dal.GenreRepository;
import fr.eni.tpludotheque.dal.JeuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JeuServiceImpl implements JeuService {

    private final JeuRepository jeuRepository;
    private final GenreRepository genreRepository;

    public JeuServiceImpl(JeuRepository jeuRepository, GenreRepository genreRepository) {
        this.jeuRepository = jeuRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public void ajouterJeu(Jeu jeu) {
        jeuRepository.save(jeu);
    }
}

