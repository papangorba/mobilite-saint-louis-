package com.techinnovsn.backend.mobilite.service;


import java.util.Optional;

import com.techinnovsn.backend.mobilite.entity.enums.Role;
import com.techinnovsn.backend.mobilite.security.JwtUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.techinnovsn.backend.mobilite.dto.RegisterClientDto;
import com.techinnovsn.backend.mobilite.entity.User;

import com.techinnovsn.backend.mobilite.repository.UserRepository;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthClientService {
    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;

    public String register(RegisterClientDto dto) {
        if (userRepository.existsByTelephone(dto.getTelephone())) {
            throw new RuntimeException("Ce numéro est déjà utilisé");
        }

        User user = new User();
        user.setTelephone(dto.getTelephone());
        user.setRole(Role.CLIENT);
//        user.setPassword(passwordEncoder.encode(String.valueOf(dto.getTelephone()))); // mot de passe = numéro chiffré
        userRepository.save(user);
        return jwtUtils.generateToken(user.getTelephone());
    }

    public String login(String telephone) {
        Optional<User> userOpt = userRepository.findByTelephone(telephone.trim());

        if (userOpt.isEmpty()) {
            throw new RuntimeException("Utilisateur non trouvé pour le numéro : " + telephone);
        }

        User user = userOpt.get();
        return jwtUtils.generateToken(user.getTelephone());
    }


}
