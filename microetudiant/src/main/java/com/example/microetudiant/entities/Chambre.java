package com.example.microetudiant.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChambre;

    @Column(unique = true)
    long numeroChambre;

    @Enumerated(EnumType.STRING)
    TypeChambre typeC;

    @OneToMany(mappedBy = "chambre",fetch =FetchType.EAGER,cascade=CascadeType.REMOVE)
    @JsonIgnoreProperties("chambre")
    private Set<Reservation> reservations;

    @ManyToOne(fetch =FetchType.EAGER,cascade=CascadeType.DETACH)
    @JsonIgnoreProperties("chambre")
    private Bloc bloc;


}
