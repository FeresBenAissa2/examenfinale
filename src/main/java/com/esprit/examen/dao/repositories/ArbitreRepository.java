package com.esprit.examen.dao.repositories;

import com.esprit.examen.dao.entites.Arbitre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArbitreRepository extends JpaRepository<Arbitre,Long> {
    Arbitre findByNomAndPrenom(String nom,String prenom);
    @Query("select a from Arbitre a, Rencontre r ,Equipe e where r.arbitre.id= a.id and r.equipeDomicile.id =:idEquipe or r.equipeExterieur=:idEquipe ")
    List<Arbitre> recupererArbitresDUneEquipe(int idEquipe);
}
