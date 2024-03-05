package com.esprit.examen.dao.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Rencontre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    LocalDate dateMatch ;
    int nbre_but ;
    String nomStade ;
    @Enumerated(EnumType.STRING)
    Niveau niveau;

    @ManyToOne
    @JsonIgnore
    Arbitre arbitre;


    @ManyToOne
    @JsonIgnore

    Equipe equipeDomicile;

    @ManyToOne
    @JsonIgnore

    Equipe equipeExterieur;
}
