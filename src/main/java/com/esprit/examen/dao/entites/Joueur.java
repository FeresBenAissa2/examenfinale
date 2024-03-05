package com.esprit.examen.dao.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Joueur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id ;
    String nom ;
    String prenom ;
    @Enumerated(EnumType.STRING)
    Poste poste;
    int num_maillot ;

    @ManyToOne
    @JsonIgnore
    Equipe equipe;
}
