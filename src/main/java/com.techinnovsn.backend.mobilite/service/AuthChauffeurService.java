package com.techinnovsn.backend.mobilite.service;

import com.techinnovsn.backend.mobilite.dto.RegisterChauffeurDto;
import com.techinnovsn.backend.mobilite.dto.LoginChauffeurDto;
import com.techinnovsn.backend.mobilite.entity.User;
import com.techinnovsn.backend.mobilite.mapper.ChauffeurMapper;
import com.techinnovsn.backend.mobilite.repository.UserRepository;
import com.techinnovsn.backend.mobilite.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthChauffeurService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChauffeurMapper chauffeurMapper;

    @Autowired
    private JwtUtils jwtUtils;

    // ✅ Inscription du chauffeur
    public String register(RegisterChauffeurDto dto) {
        if (userRepository.existsByTelephone(dto.getTelephone())) {
            throw new RuntimeException("Ce numéro de téléphone est déjà utilisé");
        }

        User chauffeur = chauffeurMapper.toEntity(dto);
       userRepository.save(chauffeur);

        return jwtUtils.generateToken(chauffeur.getTelephone());
    }

    // ✅ Connexion du chauffeur
    public String login(LoginChauffeurDto dto) {
        Optional<User> chauffeurOpt = userRepository.findByTelephone(dto.getTelephone());

        if (chauffeurOpt.isEmpty()) {
            throw new RuntimeException("Aucun chauffeur trouvé pour ce numéro");
        }

        User chauffeur = chauffeurOpt.get();

        if (chauffeur.getRole() == null || !chauffeur.getRole().name().equals("CHAUFFEUR")) {
            throw new RuntimeException("Ce compte n'est pas un chauffeur");
        }

        return jwtUtils.generateToken(chauffeur.getTelephone());
    }
}
