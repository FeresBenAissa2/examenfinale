package com.esprit.examen.scheduler;


import com.esprit.examen.dao.entites.Equipe;
import com.esprit.examen.dao.entites.Rencontre;
import com.esprit.examen.services.rencontre.IRencontreService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class Scheduler {

    IRencontreService iRencontreService;
    @Scheduled(cron = "0 0 8 * * *")
//    @Scheduled(cron = "*/5 * * * * *")

    void rencontreDeDateSys() {
        List<Rencontre> rencontres = iRencontreService.getAllRencontresByDate(LocalDate.now());
        log.info(String.valueOf(LocalDate.now()));
        log.info("*** Les rencontres d'aujourd'hui ****");
        StringBuilder rec = new StringBuilder();
        log.info(String.valueOf(rencontres.size()));
        if(!rencontres.isEmpty()){
            for(Rencontre rencontre : rencontres){
                Equipe equipe1 = rencontre.getEquipeDomicile();
                Equipe equipe2 = rencontre.getEquipeExterieur();
//                append(equipe1.getId()).append("vs").append(equipe2.getId())
                rec.append(rencontre.getNomStade());
            }
        }
        log.info(rec.toString());
    }
//
//    @Scheduled(fixedRate = 30000)
//// 5 minutes = 300 secondes = 300000 millisecondes
//    void service2() {
//        iChambreService.pourcentageChambreParTypeChambre();
//    }
//
//    @Scheduled(fixedRate = 30000)
//    void service3() {
//        iChambreService.nbPlacesDisponibleParChambreAnneeEnCours();
//    }
//    @Scheduled(cron = "* * * 30 06 *")
//    void service4() {
//        iReservationService.annulerReservations();
//    }
//    UtilistateurService utilistateurService;
//
//    @Scheduled(cron = "0/5 * * * * *" )
//    public String afficher() {
//        List<Utilisateur> utilisateurs= utilistateurService.getAllLecteurs();
//        String userString = "\n List des Lecteurs : \n ";
//        for(Utilisateur u : utilisateurs){
//           if(calculateDayDifference(u.getDateFinAbonnement(),LocalDate.now())<2)
//               userString+=u.getNom()+" "+u.getPrenom()+"\n";
//        }
//        log.info(userString);
//        return userString;
//    }
//    public static long calculateDayDifference(LocalDate date1, LocalDate date2) {
//        return ChronoUnit.DAYS.between(date1, date2);
//    }
}
