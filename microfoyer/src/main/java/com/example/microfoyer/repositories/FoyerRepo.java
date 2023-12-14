package com.example.microfoyer.repositories;



import com.example.microfoyer.entities.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoyerRepo extends JpaRepository<Foyer,Long> {
}
