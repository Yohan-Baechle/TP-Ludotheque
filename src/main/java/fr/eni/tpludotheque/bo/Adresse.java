package fr.eni.tpludotheque.bo;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "ADRESSE")
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(nullable = false, length = 100)
    private String rue;

    @NonNull
    @Column(nullable = false, length = 10)
    private String codePostal;

    @NonNull
    @Column(nullable = false, length = 50)
    private String ville;
}
