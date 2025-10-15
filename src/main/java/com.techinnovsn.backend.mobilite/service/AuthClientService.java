package com.techinnovsn.service;


import com.techinnovsn.dto.RegisterClientDto;
import com.techinnovsn.entity.User;
import com.techinnovsn.entity.enums.Role;
import com.techinnovsn.repository.UserRepository;
import com.techinnovsn.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public String login(String  telephone) {
        Optional<User> userOpt = userRepository.findByTelephone(telephone);

        if (userOpt.isEmpty()) {
            throw new RuntimeException("Utilisateur non trouvé");
        }

        return jwtUtils.generateToken(userOpt.get().getTelephone());
    }


}
