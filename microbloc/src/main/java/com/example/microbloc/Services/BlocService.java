package com.example.microbloc.Services;


import com.example.microbloc.entities.Bloc;
import com.example.microbloc.entities.Chambre;
import com.example.microbloc.entities.Foyer;
import com.example.microbloc.repositories.BlocRepo;
import com.example.microbloc.repositories.ChambreRepo;
import com.example.microbloc.repositories.FoyerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class BlocService implements IBlocService{
    BlocRepo blocRepo;
    ChambreRepo chambreRepo;
    FoyerRepo foyerRepo;
    @Override
    public List<Bloc> retrieveAllBlocs() {
        return blocRepo.findAll();
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepo.save(bloc);
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepo.save(bloc);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return blocRepo.findById(idBloc).orElse(null);
    }

    @Override
    public void removeBloc(long idBloc) {
        blocRepo.deleteById(idBloc);

    }


    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc){
        Bloc b=blocRepo.findBlocByNomBloc(nomBloc);
        Set<Chambre> cL=new HashSet<Chambre>();
        for(long n:numChambre) {
            Chambre c = chambreRepo.findByNumeroChambre(n);
            c.setBloc(b);
            cL.add(c);
        }
        b.setChambres(cL);
        return blocRepo.save(b);
    }

    @Override
    public Bloc affecterFoyerABloc(long idBloc, long idFoyer) {
        Bloc b=blocRepo.findById(idBloc).orElse(null);
        Foyer f=foyerRepo.findById(idFoyer).orElse(null);
        b.setFoyer(f);
        return blocRepo.save(b);
    }

    @Override
    public Bloc desaffecterFoyerABloc(long idBloc) {
        Bloc b=blocRepo.findById(idBloc).orElse(null);
        b.setFoyer(null);
        return blocRepo.save(b);
    }
}
