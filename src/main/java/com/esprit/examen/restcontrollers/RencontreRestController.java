package com.esprit.examen.restcontrollers;

import com.esprit.examen.dao.entites.Equipe;
import com.esprit.examen.dao.entites.Rencontre;
import com.esprit.examen.services.rencontre.IRencontreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rencontre")
@AllArgsConstructor
public class RencontreRestController {
    IRencontreService iRencontreService;

    @PostMapping("ajouterRencontreEtAffecterEquipes")
    public Rencontre ajouterRencontreEtAffecterEquipes(@RequestBody Rencontre rencontre, @RequestParam long idEquipe1, @RequestParam long idEquipe2) {
        return iRencontreService.ajouterRencontreEtAffecterEquipes(rencontre, idEquipe1, idEquipe2);
    }
    @PostMapping("incrementerNbreBut")
    public void incrementerNbreBut(int idRencontre){
        iRencontreService.incrementerNbreBut(idRencontre);
    }
}
