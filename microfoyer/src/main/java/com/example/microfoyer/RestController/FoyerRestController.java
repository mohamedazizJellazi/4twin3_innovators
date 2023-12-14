package com.example.microfoyer.RestController;



import com.example.microfoyer.entities.Foyer;
import com.example.microfoyer.services.IFoyerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "")
@RestController
@AllArgsConstructor
@RequestMapping("/foyer")
public class FoyerRestController {

    IFoyerService iFoyerService;

    @GetMapping("/affichertout")
    List<Foyer> retrieveAllFoyerss(){
        return iFoyerService.retrieveAllFoyers();
    }
    @PostMapping("/ajouterfoyer")
    Foyer addFoyer(@RequestBody Foyer f){
        return iFoyerService.addFoyer(f);
    }
    @PutMapping("/modifierfoyer")
    Foyer updateFoyer (@RequestBody Foyer f){
        return iFoyerService.updateFoyer(f);
    }
    @GetMapping("/afficherfoyer/{idFoyer}")
    Foyer retrieveFoyer (@PathVariable("idFoyer") long idFoyer){
        return iFoyerService.retrieveFoyer(idFoyer);
    }
    @DeleteMapping("/deletefoyer/{idFoyer}")
    void deleteFoyer(@PathVariable("idFoyer") long idFoyer){
        iFoyerService.removeFoyer(idFoyer);
    }
}
