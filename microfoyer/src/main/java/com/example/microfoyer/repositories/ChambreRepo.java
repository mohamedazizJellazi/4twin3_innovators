package com.example.microfoyer.repositories;



import com.example.microfoyer.entities.Chambre;
import com.example.microfoyer.entities.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChambreRepo extends JpaRepository<Chambre,Long> {

    //récupérer les chambres dont elles ont étè réservé durant une année universitaire donnée au clavier
    //List<Chambre> findChambresByReservations_
    //Récuperer les chambres définis par leur nom
    //List<Chambre> findChambresByBloc_NomBloc(String nom);
    Chambre findByNumeroChambre(long numeroChambre);

    @Query("SELECT c FROM Chambre c JOIN c.bloc b JOIN b.foyer f JOIN f.universite u WHERE u.nomUniversite = :nomUniversite")
    List<Chambre> findByNomUniversite(@Param("nomUniversite") String nomUniversite);

    @Query("SELECT c from Chambre c JOIN c.bloc b where b.idBloc=:idBloc and c.typeC=:typeC ")
    List<Chambre> findChambresByBlocEtType(long idBloc, TypeChambre typeC);


}
