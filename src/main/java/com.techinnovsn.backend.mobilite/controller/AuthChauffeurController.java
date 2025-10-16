package com.techinnovsn.backend.mobilite.controller;

import com.techinnovsn.backend.mobilite.dto.RegisterChauffeurDto;
import com.techinnovsn.backend.mobilite.dto.LoginChauffeurDto;
import com.techinnovsn.backend.mobilite.service.AuthChauffeurService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/chauffeur")
@CrossOrigin("*")
public class AuthChauffeurController {

    @Autowired
    private AuthChauffeurService authChauffeurService;

    // ✅ Inscription chauffeur
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterChauffeurDto dto) {
        String token = authChauffeurService.register(dto);
        return ResponseEntity.ok().body("Inscription réussie. Token : " + token);
    }

    // ✅ Connexion chauffeur
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginChauffeurDto dto) {
        String token = authChauffeurService.login(dto);
        return ResponseEntity.ok().body("Connexion réussie. Token : " + token);
    }
}
