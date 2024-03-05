package com.esprit.examen.dao.entites;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Arbitre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String nom ;
    String prenom ;
    String nationalite;
    @Enumerated(EnumType.STRING)
    Niveau niveau;
    @OneToMany(mappedBy = "arbitre")
    List<Rencontre> rencontres;
}
