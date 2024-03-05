package com.esprit.examen.dao.repositories;

import com.esprit.examen.dao.entites.Arbitre;
import com.esprit.examen.dao.entites.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipeRepository extends JpaRepository<Equipe,Long> {
}
