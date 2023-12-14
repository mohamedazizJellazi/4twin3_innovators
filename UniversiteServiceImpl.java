package com.example.microuniversite.Services;

import com.example.microuniversite.entities.Foyer;
import com.example.microuniversite.entities.Universite;
import com.example.microuniversite.repositories.FoyerRepo;
import com.example.microuniversite.repositories.UniversiteRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServiceImpl implements IUniversiteImpl{
    UniversiteRepo universiteRepo;
    FoyerRepo foyerRepo;
    @Override
    public List<Universite> retrieveAllUniversities() {
        return universiteRepo.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepo.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepo.save(u);
    }



    @Override
    public Universite retrieveUniversite(long idUniversite) {
        return universiteRepo.findById(idUniversite).orElse(null);
    }

    @Override
    public void removeUniversite(long idUniversite) {
        universiteRepo.deleteById(idUniversite);
    }


    @Override
        public Universite affecterFoyerAUniversite (long idFoyer, String nomUniversite){
        Foyer f=foyerRepo.findById(idFoyer).orElse(null);
        Universite u=universiteRepo.findByNomUniversite(nomUniversite);
//            if(u.getFoyer() == null) {
                u.setFoyer(f);
//            foyerRepo.save(f);
//            }
        return universiteRepo.save(u);
        }

        public Universite desaffecterFoyerAUniversite (long idFoyer, long idUniversite){
            Foyer f=foyerRepo.findById(idFoyer).orElse(null);
            Universite u=universiteRepo.findById(idUniversite).orElse(null);
        if(u.getFoyer() == f)
            u.setFoyer(null);
        return universiteRepo.save(u);
    }
}
