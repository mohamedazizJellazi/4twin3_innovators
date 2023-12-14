package com.example.microetudiant.RestController;

import com.example.microetudiant.Services.IReservationService;
import com.example.microetudiant.entities.Reservation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationRestController {

    IReservationService iReservationService;

    @GetMapping("/affichertout")
    List<Reservation> retrieveAllReservation(){return iReservationService.retrieveAllReservation();}

    @PutMapping("/modifiereservation")
    Reservation updateReservation (@RequestBody Reservation res){return iReservationService.updateReservation(res);}

    @GetMapping("/afficherreservation/{idRes}")
    Reservation retrieveReservation (@PathVariable("idRes") String idRes){
        return iReservationService.retrieveReservation(idRes);
    }
    @PostMapping("/ajouterreservation/{idChambre}/{cinEtudiant}")
    Reservation ajouterReservation(@RequestBody Reservation res,@PathVariable("idChambre") long idChambre,@PathVariable("cinEtudiant") long cinEtudiant){
        return iReservationService.ajouterReservation(res,idChambre,cinEtudiant);
    }
    @DeleteMapping("/annulerreservation/{idReservation}")
    void annulerReservation(@PathVariable("idReservation") String idReservation){
         iReservationService.annulerReservation(idReservation);
    }
}
