package com.esprit.examen.restcontrollers;

import com.esprit.examen.dao.entites.Arbitre;
import com.esprit.examen.services.arbitre.IArbitreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/arbitre")
@AllArgsConstructor
public class ArbitreRestController {
    IArbitreService iArbitreService;

    @PostMapping("ajouterArbitre")
    public Arbitre ajouterArbitre(@RequestBody Arbitre arbitre) {
        return iArbitreService.ajouterArbitre(arbitre);
    }

    @PostMapping("affecterArbitreARencontre")
    public void affecterArbitreARencontre(@RequestParam String nom, @RequestParam String prenom, @RequestParam long idR) throws Exception {

            iArbitreService.affecterArbitreARencontre(nom, prenom, idR);

    }

    @PostMapping("recupererArbitresDUneEquipe")
    public List<Arbitre> recupererArbitresDUneEquipe(@RequestParam int idEquipe) {
        return  iArbitreService.recupererArbitresDUneEquipe(idEquipe);
    }
}
