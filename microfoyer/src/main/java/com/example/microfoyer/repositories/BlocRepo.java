package com.example.microfoyer.repositories;

import com.example.microfoyer.entities.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlocRepo extends JpaRepository<Bloc,Long> {
    Bloc findBlocByNomBloc(String nomBloc);

}
