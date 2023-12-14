package com.example.microuniversite.repositories;



import com.example.microuniversite.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepo extends JpaRepository<Etudiant,Long> {
    Etudiant findEtudiantByCin(long cinEtudiant);
    Etudiant findEtudiantByEmail(String email);
}
