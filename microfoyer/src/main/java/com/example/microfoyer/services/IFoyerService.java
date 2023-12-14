package com.example.microfoyer.services;


import com.example.microfoyer.entities.Foyer;

import java.util.List;

public interface IFoyerService {
    List<Foyer> retrieveAllFoyers();

    Foyer addFoyer (Foyer f);

    Foyer updateFoyer (Foyer f);

    Foyer retrieveFoyer (long idFoyer);

    void removeFoyer (long idFoyer);

    public Foyer ajouterFoyerEtAffecterAUniversite (Foyer foyer, long idUniversite) ;
}
