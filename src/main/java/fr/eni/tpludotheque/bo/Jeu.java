package fr.eni.tpludotheque.bo;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "JEU")
public class Jeu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(nullable = false, length = 100)
    private String titre;

    @NonNull
    @Column(nullable = false, length = 50, unique = true)
    private String reference;

    @Column(name = "age_min")
    private Integer ageMin;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Integer duree;

    @Column(name = "tarif_jour", precision = 10, scale = 2)
    private BigDecimal tarifJour;
}
