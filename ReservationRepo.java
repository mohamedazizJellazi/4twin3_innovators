package com.example.microuniversite.repositories;


import com.example.microuniversite.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation,String> {
//chercher les réservations effectuées durant l'année universitaire 23/24
    Reservation findByIdReservation(String idReservation);
    void deleteByIdReservation(String idReservation);
    //List<Reservation>  findReservationByAnneUnniversitaireBetween(Date debut, Date fin);

    //long  countReservationByAnneUnniversitaireBetween(Date debut, Date fin);
}
