package com.example.microuniversite.RestController;

import com.example.microuniversite.Services.IUniversiteImpl;
import com.example.microuniversite.entities.Universite;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteRestController {

    IUniversiteImpl iUniversiteService;

    @GetMapping("/affichertout")
    List<Universite> retrieveAllUniversities(){return iUniversiteService.retrieveAllUniversities();}

   @PostMapping("/ajouteruniversite")
    Universite addUniversite (@RequestBody Universite u){return iUniversiteService.addUniversite(u);}

   @PutMapping("/modifieruniversite")
   Universite updateUniversite (@RequestBody Universite u){return iUniversiteService.updateUniversite(u);}

   @GetMapping("/afficheruniversite/{idUniversite}")
   Universite retrieveUniversite (@PathVariable("idUniversite") long idUniversite){
        return iUniversiteService.retrieveUniversite(idUniversite);
   }

    @DeleteMapping("/deleteuniversite/{idUniversite}")
    void deleteUniversite(@PathVariable("idUniversite") long idUniversite){
        iUniversiteService.removeUniversite(idUniversite);
    }

    @PutMapping("/affecteruniversitefoyer/{idFoyer}/{nomUniversite}")
    Universite affecterUniversiteFoyer (@PathVariable("idFoyer") long idFoyer,@PathVariable("nomUniversite") String nomUniversite)
    {return iUniversiteService.affecterFoyerAUniversite(idFoyer,nomUniversite);}

    @PutMapping("/desaffecteruniversitefoyer/{idFoyer}/{idUniversite}")
    Universite desaffecterUniversiteFoyer (@PathVariable("idFoyer") long idFoyer,@PathVariable("idUniversite") long idUniversite)
    {return iUniversiteService.desaffecterFoyerAUniversite(idFoyer,idUniversite);}

}
