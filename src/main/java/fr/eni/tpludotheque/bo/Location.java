package fr.eni.tpludotheque.bo;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "LOCATION")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @EqualsAndHashCode.Include
    @NonNull
    @Column(nullable = false)
    private LocalDateTime dateDebut;

    @Column
    private LocalDateTime dateRetour;

    @Column(nullable = false)
    private BigDecimal tarifJour;

    @EqualsAndHashCode.Include
    @NonNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;

    @EqualsAndHashCode.Include
    @NonNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_exemplaire", nullable = false)
    private Exemplaire exemplaire;
}
