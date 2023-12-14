package com.example.microuniversite.repositories;



import com.example.microuniversite.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation,String> {
//chercher les réservations effectuées durant l'année universitaire 23/24
    Reservation findByIdReservation(String idReservation);

    //List<Reservation>  findReservationByAnneUnniversitaireBetween(Date debut, Date fin);

    //long  countReservationByAnneUnniversitaireBetween(Date debut, Date fin);
}
