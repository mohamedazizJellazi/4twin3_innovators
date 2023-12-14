package com.example.microbloc.RestController;


import com.example.microbloc.Services.IBlocService;
import com.example.microbloc.entities.Bloc;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocRestController {
    IBlocService iBlocService;

    @GetMapping("/affichertout")
    List<Bloc> retrieveAllBlocks(){
        return iBlocService.retrieveAllBlocs();
    }
    @PostMapping("/ajouterbloc")
    Bloc addBloc(@RequestBody Bloc b){
        return iBlocService.addBloc(b);
    }
    @PutMapping("modifierbloc")
    Bloc updateBloc (@RequestBody Bloc b){
        return iBlocService.updateBloc(b);
    }
    @GetMapping("/afficherbloc/{idBloc}")
   Bloc retrieveBloc (@PathVariable("idBloc") long idBloc){
        return iBlocService.retrieveBloc(idBloc);
    }
    @DeleteMapping("/deletebloc/{idBloc}")
    void deleteBloc(@PathVariable("idBloc") long idBloc) {
        iBlocService.removeBloc(idBloc);
    }
    @PutMapping("affecterchambresabloc/{nomBloc}")
        Bloc affecterChambresABloc (@RequestBody List<Long> l,@PathVariable("nomBloc") String nomBloc){
            return iBlocService.affecterChambresABloc(l,nomBloc);
        }
    @PutMapping("affecterfoyerabloc/{idBloc}/{idFoyer}")
    Bloc affecterFoyerABloc (@PathVariable("idBloc") long idBloc,@PathVariable("idFoyer") long idFoyer){
        return iBlocService.affecterFoyerABloc(idBloc,idFoyer);
    }
    @PutMapping("desaffecterfoyerabloc/{idBloc}")
    Bloc desaffecterFoyerABloc (@PathVariable("idBloc") long idBloc){
        return iBlocService.desaffecterFoyerABloc(idBloc);
    }

}
