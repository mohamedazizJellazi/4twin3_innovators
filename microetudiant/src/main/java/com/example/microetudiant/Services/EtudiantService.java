package com.example.microetudiant.Services;

import com.example.microetudiant.entities.Etudiant;
import com.example.microetudiant.repositories.EtudiantRepo;
import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantService implements IEtudiantService {
    EtudiantRepo etudiantRepo;
    private JavaMailSender javaMailSender;



    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepo.findAll();
    }
    private static String hashPassword(String plainPassword) {
        // You can adjust the strength parameter (logRounds) based on your security requirements
        // The higher the logRounds, the more secure, but slower the hashing
        int logRounds = 12;
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt(logRounds));
    }
    @Override
    public Etudiant addEtudiant(Etudiant e) {
        String oldP=e.getMdp();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(e.getEmail());
        message.setSubject("votre mot de passe");
        message.setText(oldP);
        javaMailSender.send(message);
        e.setMdp(hashPassword(e.getMdp()));
        return etudiantRepo.save(e);
    }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> etudiants) {
        //for(Etudiant e:etudiantRepo.findAll())
           // etudiantRepo.save(e);
        return etudiantRepo.saveAll(etudiants);

    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepo.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(long idEtudiant) {
        return etudiantRepo.findById(idEtudiant).orElse(null);
    }

    @Override
    public void removeEtudiant(long idEtudiant) {
    etudiantRepo.deleteById(idEtudiant);
    }

    @Override
    public Etudiant seConnecter(String email, String mdp) {
        Etudiant e=etudiantRepo.findEtudiantByEmail(email);
        if(BCrypt.checkpw(mdp,e.getMdp())){
            return e;
        }
        else{
            return null;
        }
    }
}
