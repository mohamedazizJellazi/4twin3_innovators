package com.example.microetudiant.RestController;



import com.example.microetudiant.Services.IEtudiantService;
import com.example.microetudiant.entities.Etudiant;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantRestContoller {

    IEtudiantService iEtudiantService;

    @GetMapping("/affichertout")
    List<Etudiant> retrieveAllEtudiants(){return iEtudiantService.retrieveAllEtudiants();};

    @PostMapping("/ajouterlistetudiants")
    List<Etudiant> addEtudiant(@RequestBody List<Etudiant> etudiants){
        return iEtudiantService.addEtudiants(etudiants);
    };
    @PostMapping("/ajouteretudiant")
    Etudiant addEtudiant(@RequestBody Etudiant etudiant){
        return iEtudiantService.addEtudiant(etudiant);
    };

    @PutMapping("modifieretudiant")
    Etudiant updateEtudiant (@RequestBody Etudiant e){
        return iEtudiantService.updateEtudiant(e);
    }

    @DeleteMapping("removeetudiant/{idEtudiant}")
    String removeEtudiant(@PathVariable("idEtudiant") long idEtudiant)
    {iEtudiantService.removeEtudiant(idEtudiant);
    return "etudiant removed";
    }

    @GetMapping("/afficheretudiant/{idEtudiant}")
    Etudiant retrieveChambre (@PathVariable("idEtudiant") long idEtudiant){
        return  iEtudiantService.retrieveEtudiant(idEtudiant);
    }
    @GetMapping("/seConnecter/{email}/{mdp}")
    Etudiant seConnecter (@PathVariable("email") String email,@PathVariable("mdp") String mdp){
        return  iEtudiantService.seConnecter(email,mdp);
    }

}
