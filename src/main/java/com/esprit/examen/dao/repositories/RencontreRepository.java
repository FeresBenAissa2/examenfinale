package com.esprit.examen.dao.repositories;

import com.esprit.examen.dao.entites.Equipe;
import com.esprit.examen.dao.entites.Rencontre;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.beans.Transient;
import java.time.LocalDate;
import java.util.List;

public interface RencontreRepository extends JpaRepository<Rencontre,Long> {
    List<Rencontre> findByDateMatch(LocalDate date);
    @Modifying
    @Transactional
    @Query("update Rencontre r set r.nbre_but =r.nbre_but+1 where r.id=:idRencontre")
    void incrementerNbreBut(long idRencontre);
}
