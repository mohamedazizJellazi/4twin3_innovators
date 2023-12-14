package com.example.microchambre.RestController;


import com.example.microchambre.Services.IChambreService;
import com.example.microchambre.entities.Chambre;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreRestController {

    IChambreService iChambreService;

    @GetMapping("/affichertout")
    List<Chambre> retrieveAllChambres(){
        return iChambreService.retrieveAllChambres();
    }
    @PostMapping("/ajouterchambre")
    Chambre addChambre(@RequestBody Chambre c){
        return iChambreService.addChambre(c);
    }
    @PutMapping("modifierchambre")
    Chambre updateChambre (@RequestBody Chambre c){
        return iChambreService.updateChambre(c);
    }
    @GetMapping("/afficherchambre/{idChambre}")
    Chambre retrieveChambre (@PathVariable("idChambre") long idChambre){
        return  iChambreService.retrieveChambre(idChambre);
    }
    @DeleteMapping("/deletechambre/{idChambre}")
    void removeChambre (@PathVariable("idChambre") long idChambre){
        iChambreService.removeChambe(idChambre);
    }
}
