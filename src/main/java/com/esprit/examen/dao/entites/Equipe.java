package com.esprit.examen.dao.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String nomEquipe ;
    LocalDate dateCreation ;

    @OneToMany(mappedBy = "equipeDomicile")
    List<Rencontre> rencontresDomicile;

    @OneToMany(mappedBy = "equipeExterieur")

    List<Rencontre> rencontresExterieur;

    @OneToMany(mappedBy = "equipe",cascade = CascadeType.ALL)

    List<Joueur> joueurs;
}
