package fr.eni.tpludotheque.bo;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "EXEMPLAIRE")
public class Exemplaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Integer id;

    @Column(length = 13, nullable = false, unique = true)
    @NonNull
    private String codebarre;

    @Column(nullable = false)
    private boolean louable = true;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_jeu", nullable = false)
    @NonNull
    private Jeu jeu;
}
