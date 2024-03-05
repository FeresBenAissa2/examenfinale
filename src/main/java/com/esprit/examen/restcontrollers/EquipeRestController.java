package com.esprit.examen.restcontrollers;

import com.esprit.examen.dao.entites.Arbitre;
import com.esprit.examen.dao.entites.Equipe;
import com.esprit.examen.services.equipe.IEquipeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/equipe")
@AllArgsConstructor
public class EquipeRestController {
    IEquipeService iEquipeService;
    @PostMapping("ajouterEquipeEtJoueurs")
    public Equipe ajouterEquipeEtJoueurs(@RequestBody Equipe equipe) {
        return iEquipeService.ajouterEquipeEtJoueurs(equipe);
    }
}
