package com.techinnovsn.controller;

import com.techinnovsn.dto.RegisterClientDto;
import com.techinnovsn.service.AuthClientService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthClientService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterClientDto dto) {
        String token = authService.register(dto);
        return ResponseEntity.ok().body("Inscription réussie. Token : " + token);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String telephone) {
        String token = authService.login(telephone);
        return ResponseEntity.ok().body("Connexion réussie. Token : " + token);
    }
}
