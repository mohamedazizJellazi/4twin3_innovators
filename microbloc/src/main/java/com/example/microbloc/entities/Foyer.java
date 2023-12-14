package com.example.microbloc.entities;



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
public class Foyer  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer;

    @Column(unique = true)
    String nomFoyer;

    long capaciteFoyer;

    @OneToOne(mappedBy = "foyer",fetch =FetchType.EAGER,cascade=CascadeType.DETACH)
    @JsonIgnoreProperties("foyer")
    private Universite universite;



    @OneToMany(mappedBy = "foyer",fetch =FetchType.EAGER,cascade=CascadeType.REMOVE)
    @JsonIgnoreProperties("foyer")
    private Set<Bloc> blocs;



}
