package com.esprit.examen.services.equipe;

import com.esprit.examen.dao.entites.Equipe;
import com.esprit.examen.dao.entites.Joueur;
import com.esprit.examen.dao.repositories.EquipeRepository;
import com.esprit.examen.dao.repositories.JoueurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EquipeService implements IEquipeService{
    EquipeRepository equipeRepository;
    JoueurRepository joueurRepository;
    @Override
    public Equipe ajouterEquipeEtJoueurs(Equipe equipe) {
        Equipe savedEquipe = equipeRepository.save(equipe);

        if (savedEquipe.getJoueurs() != null) {
            for (Joueur joueur : savedEquipe.getJoueurs()) {
                joueur.setEquipe(savedEquipe);
            }
            // Save each Joueur individually
            joueurRepository.saveAll(savedEquipe.getJoueurs());
        }

        return savedEquipe;
    }
}
