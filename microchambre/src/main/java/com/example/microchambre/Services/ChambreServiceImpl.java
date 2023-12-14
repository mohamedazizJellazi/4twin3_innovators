package com.example.microchambre.Services;


import com.example.microchambre.entities.Bloc;
import com.example.microchambre.entities.Chambre;
import com.example.microchambre.entities.TypeChambre;
import com.example.microchambre.repositories.BlocRepo;
import com.example.microchambre.repositories.ChambreRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class ChambreServiceImpl implements IChambreService  {

    ChambreRepo chambreRepo;

    BlocRepo blocRepo;


    @Override
    public List<Chambre> retrieveAllChambres() {
        return chambreRepo.findAll();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepo.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return chambreRepo.save(c);
    }

    @Override
    public Chambre retrieveChambre(long idChambre) {
        return chambreRepo.findById(idChambre).orElse(null);
    }

    @Override
    public void removeChambe(long idChambre) {
        chambreRepo.deleteById(idChambre);
    }

//    List<Chambre> getChambreByReservationAnneeUniversitare(Date debut, Date fin){
//        List<Chambre> chambres=null;
//        for(Chambre c:chambreRepo.findAll())
//            for(Reservation r:c.getReservations())
//                if(r.getAnneeUniversitaire().after(debut) && r.getAnneeUniversitaire().before(fin))
//                    chambres.add(c);
//        return chambres;
//
//    }

    @Override
    public List<Chambre>  getChambresParNomUniversite( String nomUniversite){
        return chambreRepo.findByNomUniversite(nomUniversite);
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC){
      Bloc b=blocRepo.findById(idBloc).orElse(null);
      List<Chambre> chambreRes=new ArrayList<Chambre>();
      for(Chambre c:b.getChambres()){
          if(c.getTypeC() == typeC){
              chambreRes.add(c);
          }
      }
      return chambreRes;
    }
}
