package com.example.microetudiant.Services;


import com.example.microetudiant.entities.Reservation;

import java.util.List;

public interface IReservationService {
    List<Reservation> retrieveAllReservation();

    Reservation updateReservation (Reservation res);

    Reservation retrieveReservation (String idReservation);

    public Reservation ajouterReservation (Reservation reservation,long idChambre, long cinEtudiant) ;

    public void annulerReservation (String idReservation);

//    public List<Reservation>  getReservationParAnneeUniversitaireEtNomUniversite(LocalDate anneeUniversite, String nomUniversite);
}
