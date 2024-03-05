package com.esprit.examen.services.rencontre;

import com.esprit.examen.dao.entites.Rencontre;

import java.time.LocalDate;
import java.util.List;

public interface IRencontreService {
    Rencontre ajouterRencontreEtAffecterEquipes(Rencontre rencontre, long idEquipe1,long idEquipe2);
    List<Rencontre> getAllRencontresByDate(LocalDate date);

    void incrementerNbreBut(long idRencontre);
}
