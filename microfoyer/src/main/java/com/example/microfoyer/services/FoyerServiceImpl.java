package com.example.microfoyer.services;


import com.example.microfoyer.entities.Bloc;
import com.example.microfoyer.entities.Foyer;
import com.example.microfoyer.entities.Universite;
import com.example.microfoyer.repositories.BlocRepo;
import com.example.microfoyer.repositories.FoyerRepo;
import com.example.microfoyer.repositories.UniversiteRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class FoyerServiceImpl implements IFoyerService{

    FoyerRepo foyerRepo;
    BlocRepo blocRepo;
    UniversiteRepo universiteRepo;
    @Override
    public List<Foyer> retrieveAllFoyers() {
        return foyerRepo.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepo.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepo.save(f);
    }

    @Override
    public Foyer retrieveFoyer(long idFoyer) {
        return foyerRepo.findById(idFoyer).orElse(null);
    }

    @Override
    public void removeFoyer(long idFoyer) {


        foyerRepo.deleteById(idFoyer);
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite (Foyer foyer, long idUniversite){
     Set<Bloc> blocs=foyer.getBlocs();
     blocRepo.saveAll(blocs);
     Universite u=universiteRepo.findById(idUniversite).orElse(null);
     if(u.getFoyer()==null){
         u.setFoyer(foyer);
         universiteRepo.save(u);
     }
     return foyerRepo.save(foyer);
    }
}
