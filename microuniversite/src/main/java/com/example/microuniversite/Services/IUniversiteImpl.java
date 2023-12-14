package com.example.microuniversite.Services;


import com.example.microuniversite.entities.Universite;

import java.util.List;

public interface IUniversiteImpl {
    List<Universite> retrieveAllUniversities();

    Universite addUniversite (Universite u);

    Universite updateUniversite (Universite u);

    Universite retrieveUniversite (long idUniversite);

    void removeUniversite (long idUniversite);

    public Universite affecterFoyerAUniversite (long idFoyer, String nomUniversite) ;

    public Universite desaffecterFoyerAUniversite (long idFoyer, long idUniversite) ;
}
