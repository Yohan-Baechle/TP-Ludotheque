package fr.eni.tpludotheque.bo;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "CLIENT")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(nullable = false, length = 50)
    private String nom;

    @NonNull
    @Column(nullable = false, length = 50)
    private String prenom;

    @Column(length = 20)
    private String noTelephone;

    @NonNull
    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_adresse", referencedColumnName = "id")
    private Adresse adresse;
}
