package com.example.microfoyer.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUniversite;

    @Column(unique = true)
    String nomUniversite;

    String adresse;

    @OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.DETACH)
    @JsonIgnoreProperties("universite")
    private Foyer foyer;
}
