package com.example.microbloc.Services;


import com.example.microbloc.entities.Bloc;

import java.util.List;

public interface IBlocService {

    List<Bloc> retrieveAllBlocs();

    Bloc updateBloc (Bloc bloc);

    Bloc addBloc (Bloc bloc);

    Bloc retrieveBloc (long idBloc);

    void removeBloc (long idBloc);

    Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc);

    Bloc affecterFoyerABloc(long idBloc,long idFoyer);

    Bloc desaffecterFoyerABloc(long idBloc);
}
