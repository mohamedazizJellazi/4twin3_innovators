package com.example.microetudiant.Services;


import com.example.microetudiant.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    List<Etudiant> retrieveAllEtudiants();

    Etudiant addEtudiant (Etudiant e);
    List<Etudiant> addEtudiants(List<Etudiant> etudiants);
    Etudiant updateEtudiant(Etudiant e);
    Etudiant retrieveEtudiant(long idEtudiant);
    void removeEtudiant(long idEtudiant);

    Etudiant seConnecter(String email,String mdp);
}
