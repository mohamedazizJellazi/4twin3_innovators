package com.example.microbloc.repositories;


import com.example.microbloc.entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversiteRepo extends JpaRepository<Universite,Long> {
    Universite findByNomUniversite(String nomUniversite);
}
