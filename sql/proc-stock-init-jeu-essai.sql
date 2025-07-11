CREATE OR ALTER PROCEDURE init_jeu_essai
AS
BEGIN
    SET NOCOUNT ON;

    DECLARE @id_jeu INT;
    DECLARE @id_adresse INT;

    -- Nettoyage des tables dans l'ordre des contraintes FK
    DELETE FROM location;
    DELETE FROM exemplaire;
    DELETE FROM jeu;
    DELETE FROM client;
    DELETE FROM adresse;
    DELETE FROM genre;

    -- Insertion des genres
    INSERT INTO genre (libelle) VALUES ('Jeu de plateau');
    INSERT INTO genre (libelle) VALUES ('Jeu de cartes');
    INSERT INTO genre (libelle) VALUES ('Jeu de stratégie');
    INSERT INTO genre (libelle) VALUES ('Coopératif');
    INSERT INTO genre (libelle) VALUES ('Jeu de dé');
    INSERT INTO genre (libelle) VALUES ('Jeu d''enquete');

    -- Insertion adresses + clients
    INSERT INTO adresse (rue, code_postal, ville) VALUES ('rue des Cormorans', '79000', 'Niort');
    SET @id_adresse = SCOPE_IDENTITY();
    INSERT INTO client (nom, prenom, email, no_telephone, id_adresse)
    VALUES ('Curie', 'Marie', 'marie.curie@example.com', '123456789', @id_adresse);

    INSERT INTO adresse (rue, code_postal, ville) VALUES ('rue des marguerites', '79500', 'Melle');
    SET @id_adresse = SCOPE_IDENTITY();
    INSERT INTO client (nom, prenom, email, no_telephone, id_adresse)
    VALUES ('Einstein', 'Albert', 'albert.einstein@example.com', '0123456789', @id_adresse);

    -- Insertion jeux + exemplaires
    INSERT INTO jeu (titre, description, reference, duree, age_min, tarif_jour, id_genre)
    VALUES ('Pandemic', 'Descr pandemic', 'refPandemic', 30, 10, 12.5, 3); -- Genre 'Jeu de stratégie'

    SET @id_jeu = SCOPE_IDENTITY();
    INSERT INTO exemplaire (id_jeu, codebarre, louable) VALUES (@id_jeu, '1111111111111', 1);
    INSERT INTO exemplaire (id_jeu, codebarre, louable) VALUES (@id_jeu, '2222222222222', 0);
    INSERT INTO exemplaire (id_jeu, codebarre, louable) VALUES (@id_jeu, '3333333333333', 1);

    INSERT INTO jeu (titre, description, reference, duree, age_min, tarif_jour, id_genre)
    VALUES ('Welcome', 'Descr welcome', 'refWelcome', 30, 10, 9.3, 2); -- Genre 'Jeu de cartes'

    SET @id_jeu = SCOPE_IDENTITY();
    INSERT INTO exemplaire (id_jeu, codebarre, louable) VALUES (@id_jeu, '4444444444444', 1);
    INSERT INTO exemplaire (id_jeu, codebarre, louable) VALUES (@id_jeu, '5555555555555', 0);
    INSERT INTO exemplaire (id_jeu, codebarre, louable) VALUES (@id_jeu, '6666666666666', 1);
END;
