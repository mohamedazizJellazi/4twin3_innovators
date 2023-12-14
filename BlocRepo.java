package com.example.microuniversite.repositories;


import com.example.microuniversite.entities.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlocRepo extends JpaRepository<Bloc,Long> {
    Bloc findBlocByNomBloc(String nomBloc);

}
