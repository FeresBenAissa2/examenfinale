package com.esprit.examen.services.rencontre;

import com.esprit.examen.dao.entites.Equipe;
import com.esprit.examen.dao.entites.Rencontre;
import com.esprit.examen.dao.repositories.EquipeRepository;
import com.esprit.examen.dao.repositories.RencontreRepository;
import com.esprit.examen.services.equipe.IEquipeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class RencontreService implements IRencontreService {
    RencontreRepository rencontreRepository;
    EquipeRepository equipeRepository;

    @Override
    public Rencontre ajouterRencontreEtAffecterEquipes(Rencontre rencontre, long idEquipe1, long idEquipe2) {
        Equipe equipe1 = equipeRepository.findById(idEquipe1).get();
        Equipe equipe2 = equipeRepository.findById(idEquipe2).get();
        rencontre.setEquipeDomicile(equipe1);
        rencontre.setEquipeExterieur(equipe2);
        rencontre.setNbre_but(0);
        return rencontreRepository.save(rencontre);
    }

    @Override
    public List<Rencontre> getAllRencontresByDate(LocalDate date) {
        return rencontreRepository.findByDateMatch(date);
    }

    @Override
    public void incrementerNbreBut(long idRencontre) {
        Rencontre rencontre = rencontreRepository.findById(idRencontre).get();
//        if (!rencontre.getDateMatch().equals(LocalDate.now()))
            rencontreRepository.incrementerNbreBut(idRencontre);
    }


}
