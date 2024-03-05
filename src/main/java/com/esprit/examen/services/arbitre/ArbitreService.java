package com.esprit.examen.services.arbitre;

import com.esprit.examen.dao.entites.Arbitre;
import com.esprit.examen.dao.entites.Rencontre;
import com.esprit.examen.dao.repositories.ArbitreRepository;
import com.esprit.examen.dao.repositories.RencontreRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ArbitreService implements IArbitreService{
    ArbitreRepository arbitreRepository;
    RencontreRepository rencontreRepository;
    @Override
    public Arbitre ajouterArbitre(Arbitre arbitre) {
        return arbitreRepository.save(arbitre);
    }

    @Override
    public void affecterArbitreARencontre(String nom, String prenom, long idR) throws Exception {
        Arbitre arbitre = arbitreRepository.findByNomAndPrenom(nom,prenom);
        Rencontre rencontre = rencontreRepository.findById(idR).get();
        log.info(String.valueOf(arbitre.getNiveau()));
        log.info(String.valueOf(rencontre.getNiveau()));
        log.info(String.valueOf(String.valueOf(arbitre.getNiveau()).equals(String.valueOf(rencontre.getNiveau()))));
        if(!String.valueOf(arbitre.getNiveau()).equals(String.valueOf(rencontre.getNiveau()))) {
            throw new Exception("Exception declanchee");
        }else {
            rencontre.setArbitre(arbitre);
            rencontreRepository.save(rencontre);
        }
    }

    @Override
    public List<Arbitre> recupererArbitresDUneEquipe(int idEquipe) {
        return arbitreRepository.recupererArbitresDUneEquipe(idEquipe);
    }
}
