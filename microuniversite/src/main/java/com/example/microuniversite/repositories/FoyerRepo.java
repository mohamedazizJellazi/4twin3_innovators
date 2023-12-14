package com.example.microuniversite.repositories;



import com.example.microuniversite.entities.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoyerRepo extends JpaRepository<Foyer,Long> {
}
