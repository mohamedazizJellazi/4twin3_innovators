package com.example.microetudiant.Services;


import com.example.microetudiant.entities.Chambre;
import com.example.microetudiant.entities.Etudiant;
import com.example.microetudiant.entities.Reservation;
import com.example.microetudiant.repositories.ChambreRepo;
import com.example.microetudiant.repositories.EtudiantRepo;
import com.example.microetudiant.repositories.ReservationRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservationService{
    ReservationRepo reservationRepo;
    ChambreRepo chambreRepo;

    EtudiantRepo etudiantRepo;
    @Override
    public List<Reservation> retrieveAllReservation() {
        return reservationRepo.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        return reservationRepo.save(res);
    }

    @Override
    public Reservation retrieveReservation(String idReservation) {
        return reservationRepo.findByIdReservation(idReservation);
    }

    @Override
    public Reservation ajouterReservation (Reservation reservation,long idChambre, long cinEtudiant) {
        Chambre c = chambreRepo.findById(idChambre).orElse(null);
        Etudiant e=etudiantRepo.findEtudiantByCin(cinEtudiant);
        String nomBloc = c.getBloc().getNomBloc();
        long numChambre = c.getNumeroChambre();
        reservation.setIdReservation(numChambre + "-" + nomBloc + "-" + cinEtudiant);
        reservation.setEstValide(true);


            Set<Reservation> listRE=e.getReservations();
            listRE.add(reservation);
            reservation.setEtudiant(e);
            e.setReservations(listRE);
            reservation.setChambre(c);
            Set<Reservation> listCR = c.getReservations();
            listCR.add(reservation);
            c.setReservations(listCR);


        return  reservationRepo.save(reservation);
    }

    @Override
    public void annulerReservation (String idReservation){

         reservationRepo.deleteById(idReservation);

    }



}
