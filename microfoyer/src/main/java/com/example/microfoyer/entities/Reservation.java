package com.example.microfoyer.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    private String idReservation;

    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate anneeUniversitaire;

    boolean estValide;



    @ManyToOne(fetch =FetchType.EAGER,cascade=CascadeType.DETACH)
    @JsonIgnoreProperties("reservations")
    private Etudiant etudiant;

    @ManyToOne(fetch =FetchType.EAGER,cascade=CascadeType.DETACH)
    @JsonIgnoreProperties("reservations")
    private Chambre chambre;
}
