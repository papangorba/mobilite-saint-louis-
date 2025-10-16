package com.techinnovsn.backend.mobilite.controller;

import com.techinnovsn.backend.mobilite.dto.LoginClientRequestDto;
import com.techinnovsn.backend.mobilite.dto.RegisterClientDto;
import com.techinnovsn.backend.mobilite.service.AuthClientService;

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
    public ResponseEntity<?> login(@RequestBody LoginClientRequestDto request) {
        String token = authService.login(request.getTelephone());
        return ResponseEntity.ok().body("Connexion réussie. Token : " + token);
    }

}
