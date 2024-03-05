package com.esprit.examen.dao.repositories;

import com.esprit.examen.dao.entites.Equipe;
import com.esprit.examen.dao.entites.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JoueurRepository extends JpaRepository<Joueur,Long> {
}
