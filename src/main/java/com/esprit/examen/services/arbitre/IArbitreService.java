package com.esprit.examen.services.arbitre;

import com.esprit.examen.dao.entites.Arbitre;

import java.util.List;

public interface IArbitreService {
    Arbitre ajouterArbitre(Arbitre arbitre);
    void affecterArbitreARencontre(String nom,String prenom, long idR) throws Exception;

    List<Arbitre> recupererArbitresDUneEquipe(int idEquipe);

}
