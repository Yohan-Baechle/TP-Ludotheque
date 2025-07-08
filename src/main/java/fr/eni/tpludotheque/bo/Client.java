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
    @Column(name = "no_client")
    private Integer noClient;

    @NonNull
    @Column(nullable = false, length = 50)
    private String nom;

    @NonNull
    @Column(nullable = false, length = 50)
    private String prenom;

    @Column(length = 20)
    private String noTelephone;

    @NonNull
    @Column(nullable = false, length = 100)
    private String email;
}
