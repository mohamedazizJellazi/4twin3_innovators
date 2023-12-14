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
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;

    @Column(unique = true)
    String nomBloc;

    long capaciteBloc;

    @ManyToOne(fetch =FetchType.EAGER,cascade=CascadeType.DETACH)
    private Foyer foyer;

    @OneToMany(mappedBy = "bloc",fetch =FetchType.EAGER,cascade=CascadeType.REMOVE)
    @JsonIgnoreProperties("bloc")
    private Set<Chambre> chambres;
}
