package com.example.microchambre.Services;


import com.example.microchambre.entities.Chambre;
import com.example.microchambre.entities.TypeChambre;

import java.util.List;

public interface IChambreService {
    List<Chambre> retrieveAllChambres();

    Chambre addChambre(Chambre c); // ajouter l’équipe avec son détail

    Chambre updateChambre (Chambre c);

    Chambre retrieveChambre (long idChambre);

    void removeChambe (long idChambre);
    List<Chambre>  getChambresParNomUniversite( String nomUniversite);

    List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC);
}
