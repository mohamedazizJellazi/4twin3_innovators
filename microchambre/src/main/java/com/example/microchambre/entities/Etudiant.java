package com.example.microchambre.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant;

    String nomEt;

    String prenomEt;

    @Column(unique = true)
    long cin;

    String ecole;

    @Column(unique = true)
    String email;

    String mdp;

    @Temporal(TemporalType.DATE)
    Date dateNaissance;

    @OneToMany(mappedBy = "etudiant",fetch =FetchType.EAGER,cascade=CascadeType.REMOVE)
    @JsonIgnoreProperties("etudiant")
    private Set<Reservation> reservations;
}
